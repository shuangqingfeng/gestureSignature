package gesturesignature.fengunion.com.gesturesignature;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.IOException;

/**
 * @author shuang
 * @date 2016/11/3
 */

public class SignatureActivity extends Activity {
    private static final String TAG = SignatureActivity.class.getSimpleName();
    private GestureSignatureView mMSignature;
    public static String signaturePath= Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "signature.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_signature);
        mMSignature = (GestureSignatureView) findViewById(R.id.gsv_signature);

        findViewById(R.id.btn_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMSignature.clear();
            }
        });
        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mMSignature.save(signaturePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
