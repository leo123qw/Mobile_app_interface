package student.mycamear;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yanzhenjie.permission.AndPermission;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Android M版本以上动态获取权限(此处获取了自动拨打电话以及读取联系人的权限)，使用了AndPermission库
        AndPermission.with(this)
                .requestCode(101)
                .permission(Manifest.permission.CAMERA,
                        Manifest.permission.READ_CONTACTS)
                .send();

        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.open);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CameraActivity.class);
                startActivity(intent);
            }
        });
    }
}
