package cc.worksite.aoko;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cc.worksite.aoko.util.Infos;
import cc.worksite.aoko.util.LogUtil;
import cc.worksite.aoko.util.ToastUtil;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UploadFileListener;

public class ReleaseActivity extends AppCompatActivity implements View.OnClickListener {
    private Button photo, video, release;
    private ImageView img_back;
    private EditText title, summary, describe, phone;
    String phone_num = null;
    String _title = null;
    String _summary = null;
    String _describe = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        Bmob.initialize(ReleaseActivity.this, "1ada93470281020adc01c3a44f372fe1");
        setContentView(R.layout.activity_release);
        photo = (Button) findViewById(R.id.add_photo);
        video = (Button) findViewById(R.id.add_video);
        title = (EditText) findViewById(R.id.title);
        summary = (EditText) findViewById(R.id.summary);
        describe = (EditText) findViewById(R.id.describe);
        phone = (EditText) findViewById(R.id.phone);

        release = (Button) findViewById(R.id.release);
        img_back = (ImageView) findViewById(R.id.back);


        photo.setOnClickListener(this);
        video.setOnClickListener(this);
        release.setOnClickListener(this);
        img_back.setOnClickListener(this);
    }

    public static boolean isMobileNO(String mobiles) {
        String telRegex = "[1][34578]\\d{9}";
        return mobiles.matches(telRegex);
    }

    boolean flag = true;

    private void check() {

        _title = title.getText().toString();
        _summary = summary.getText().toString();
        _describe = describe.getText().toString();
        phone_num = phone.getText().toString();

        if (TextUtils.isEmpty(_title)) {
            ToastUtil.show(this, "请填写标题", 0);
            flag = false;
            return;
        }
        if (TextUtils.isEmpty(_summary)) {
            ToastUtil.show(this, "请填写概要", 0);
            flag = false;
            return;

        }
        if (TextUtils.isEmpty(_describe)) {
            ToastUtil.show(this, "请填写描述", 0);
            flag = false;
            return;

        }
        if (TextUtils.isEmpty(phone_num)) {
            ToastUtil.show(this, "请填写手机号", 0);
            flag = false;
            return;
        }
        if (!isMobileNO(phone_num)) {
            ToastUtil.show(this, "请填写正确的手机号", 0);
            flag = false;
            return;
        }
    }

    public void saveMyBitmap(String bitName, Bitmap mBitmap) {
        File f = new File("/sdcard/" + bitName + ".png");
        try {
            f.createNewFile();
        } catch (IOException e) {
            ToastUtil.show(ReleaseActivity.this, "保存失败", 0);
        }
        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
        try {
            fOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (data == null) {
                return;
            } else {
                Bundle extras = data.getExtras();
                if (extras != null) {
                    Bitmap bitmap = extras.getParcelable("data");
                    ImageView imageView = (ImageView) findViewById(R.id.release_img);
                    saveMyBitmap("temp", bitmap);
                    imageView.setImageBitmap(bitmap);
                }
            }
        } else if (requestCode == 2) {
            if (data == null) {
                return;
            } else {

            }
        }
    }

    private Uri convertUri(Uri uri) {
        InputStream is = null;
        try {
            is = getContentResolver().openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();
            return saveBitmap(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private Uri saveBitmap(Bitmap bitmap) {
        File dir = new File(Environment.getExternalStorageDirectory() + "/cc.worksite.lee");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File img = new File(dir.getAbsolutePath() + "temp.png");
        try {
            FileOutputStream fos = new FileOutputStream(img);
            bitmap.compress(Bitmap.CompressFormat.PNG, 80, fos);
            fos.flush();
            fos.close();
            return Uri.fromFile(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_photo:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 1);
                loadImg();

                break;
            case R.id.add_video:
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/*");
                startActivityForResult(i, 2);
                break;
            case R.id.release:
                check();
                if (true == flag) {
                    Infos info = new Infos();
                    info.setTitle(_title);
                    info.setSummary(_summary);
                    info.setDescribe(_describe);
                    info.setPhone(phone_num);

                    info.setPhoto_uri(photoUri);
                    info.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e == null) {
                                ToastUtil.show(ReleaseActivity.this, "提交成功", 0);
                                finish();
                            } else {
                                ToastUtil.show(ReleaseActivity.this, "提交失败"+e.toString(), 0);
                            }
                        }
                    });
                }
                break;
            case R.id.back:
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.fade_out);
                break;

        }
    }
    String photoUri = null;
    BmobFile bmobFile=null;
    private void loadImg() {
        final String picPath = "/sdcard/temp.png";
        bmobFile = new BmobFile(new File(picPath));
        bmobFile.uploadblock(new UploadFileListener() {

            @Override
            public void done(BmobException e) {
                if (e == null) {
                    photoUri = bmobFile.getFileUrl();

                } else {
                    flag =false;
                    ToastUtil.show(ReleaseActivity.this, "上传失败"+e, 0);
                }

            }

            @Override
            public void onProgress(Integer value) {
                // 返回的上传进度（百分比）
            }
        });
    }

}
