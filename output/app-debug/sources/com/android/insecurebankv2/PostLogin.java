package com.android.insecurebankv2;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.marcohc.toasteroid.Toasteroid;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public class PostLogin extends Activity {
    Button changepasswd_button;
    TextView root_status;
    Button statement_button;
    Button transfer_button;
    String uname;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_login);
        Intent intent = getIntent();
        this.uname = intent.getStringExtra("uname");
        this.root_status = (TextView) findViewById(R.id.rootStatus);
        showRootStatus();
        checkEmulatorStatus();
        this.transfer_button = (Button) findViewById(R.id.trf_button);
        this.transfer_button.setOnClickListener(new View.OnClickListener() { // from class: com.android.insecurebankv2.PostLogin.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                Intent dT = new Intent(PostLogin.this.getApplicationContext(), (Class<?>) DoTransfer.class);
                PostLogin.this.startActivity(dT);
            }
        });
        this.statement_button = (Button) findViewById(R.id.viewStatement_button);
        this.statement_button.setOnClickListener(new View.OnClickListener() { // from class: com.android.insecurebankv2.PostLogin.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PostLogin.this.viewStatment();
            }
        });
        this.changepasswd_button = (Button) findViewById(R.id.button_ChangePasswd);
        this.changepasswd_button.setOnClickListener(new View.OnClickListener() { // from class: com.android.insecurebankv2.PostLogin.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                PostLogin.this.changePasswd();
            }
        });
    }

    private void checkEmulatorStatus() {
        Boolean isEmulator = checkIfDeviceIsEmulator();
        if (isEmulator.booleanValue()) {
            Toasteroid.show(this, "Application running on Emulator", Toasteroid.STYLES.ERROR, 1);
        } else {
            Toasteroid.show(this, "Application running on Real device", Toasteroid.STYLES.SUCCESS, 1);
        }
    }

    private Boolean checkIfDeviceIsEmulator() {
        if (Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || ((Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT))) {
            return true;
        }
        return false;
    }

    void showRootStatus() {
        boolean isrooted = doesSuperuserApkExist("/system/app/Superuser.apk") || doesSUexist();
        if (isrooted) {
            this.root_status.setText("Rooted Device!!");
        } else {
            this.root_status.setText("Device not Rooted!!");
        }
    }

    private boolean doesSUexist() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"/system/bin/which", "su"});
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            if (in.readLine() != null) {
                if (process != null) {
                    process.destroy();
                }
                return true;
            }
            if (process != null) {
                process.destroy();
            }
            return false;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    private boolean doesSuperuserApkExist(String s) {
        File rootFile = new File("/system/app/Superuser.apk");
        Boolean doesexist = Boolean.valueOf(rootFile.exists());
        return doesexist.booleanValue();
    }

    protected void changePasswd() {
        Intent cP = new Intent(getApplicationContext(), (Class<?>) ChangePassword.class);
        cP.putExtra("uname", this.uname);
        startActivity(cP);
    }

    protected void viewStatment() {
        Intent vS = new Intent(getApplicationContext(), (Class<?>) ViewStatement.class);
        vS.putExtra("uname", this.uname);
        startActivity(vS);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            callPreferences();
            return true;
        }
        if (id == R.id.action_exit) {
            Intent i = new Intent(getBaseContext(), (Class<?>) LoginActivity.class);
            i.addFlags(67108864);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void callPreferences() {
        Intent i = new Intent(this, (Class<?>) FilePrefActivity.class);
        startActivity(i);
    }
}
