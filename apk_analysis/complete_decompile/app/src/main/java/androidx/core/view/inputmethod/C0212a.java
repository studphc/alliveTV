package androidx.core.view.inputmethod;

import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.inputmethod.InputConnectionCompat;

/* renamed from: androidx.core.view.inputmethod.a */
/* loaded from: classes.dex */
public final class C0212a extends InputConnectionWrapper {

    /* renamed from: a */
    public final /* synthetic */ InputConnectionCompat.OnCommitContentListener f3992a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0212a(InputConnection inputConnection, InputConnectionCompat.OnCommitContentListener onCommitContentListener) {
        super(inputConnection, false);
        this.f3992a = onCommitContentListener;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        if (this.f3992a.onCommitContent(InputContentInfoCompat.wrap(inputContentInfo), i, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
