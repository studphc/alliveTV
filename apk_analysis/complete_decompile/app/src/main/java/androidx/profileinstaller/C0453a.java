package androidx.profileinstaller;

import android.util.Log;
import androidx.profileinstaller.ProfileInstaller;

/* renamed from: androidx.profileinstaller.a */
/* loaded from: classes.dex */
public final class C0453a implements ProfileInstaller.DiagnosticsCallback {

    /* renamed from: a */
    public final /* synthetic */ ProfileInstallReceiver f6920a;

    public C0453a(ProfileInstallReceiver profileInstallReceiver) {
        this.f6920a = profileInstallReceiver;
    }

    @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
    public final void onDiagnosticReceived(int i, Object obj) {
        String str;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            str = "";
                        } else {
                            str = "DIAGNOSTIC_PROFILE_IS_COMPRESSED";
                        }
                    } else {
                        str = "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST";
                    }
                } else {
                    str = "DIAGNOSTIC_REF_PROFILE_EXISTS";
                }
            } else {
                str = "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST";
            }
        } else {
            str = "DIAGNOSTIC_CURRENT_PROFILE_EXISTS";
        }
        Log.d("ProfileInstaller", str);
    }

    @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
    public final void onResultReceived(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i != 6 && i != 7 && i != 8) {
            Log.d("ProfileInstaller", str);
        } else {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        }
        this.f6920a.setResultCode(i);
    }
}
