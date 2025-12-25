package p000;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class i41 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m5162a(InputConnection inputConnection, InputContentInfo inputContentInfo, int i, Bundle bundle) {
        return inputConnection.commitContent(inputContentInfo, i, bundle);
    }
}
