package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import p000.C1294i5;
import p000.i41;
import p000.y70;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public final class InputConnectionCompat {
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;

    /* loaded from: classes.dex */
    public interface OnCommitContentListener {
        boolean onCommitContent(@NonNull InputContentInfoCompat inputContentInfoCompat, int i, @Nullable Bundle bundle);
    }

    @Deprecated
    public InputConnectionCompat() {
    }

    public static boolean commitContent(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull InputContentInfoCompat inputContentInfoCompat, int i, @Nullable Bundle bundle) {
        char c;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 25) {
            return i41.m5162a(inputConnection, y70.m8239k(inputContentInfoCompat.unwrap()), i, bundle);
        }
        boolean z = true;
        if (i2 >= 25) {
            c = 1;
        } else {
            Bundle bundle2 = editorInfo.extras;
            if (bundle2 != null) {
                boolean containsKey = bundle2.containsKey("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                boolean containsKey2 = editorInfo.extras.containsKey("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                if (containsKey && containsKey2) {
                    c = 4;
                } else if (containsKey) {
                    c = 3;
                } else if (containsKey2) {
                    c = 2;
                }
            }
            c = 0;
        }
        if (c != 2) {
            if (c != 3 && c != 4) {
                return false;
            }
            z = false;
        }
        Bundle bundle3 = new Bundle();
        if (z) {
            str = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
        } else {
            str = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
        }
        bundle3.putParcelable(str, inputContentInfoCompat.getContentUri());
        if (z) {
            str2 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
        } else {
            str2 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
        }
        bundle3.putParcelable(str2, inputContentInfoCompat.getDescription());
        if (z) {
            str3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
        } else {
            str3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
        }
        bundle3.putParcelable(str3, inputContentInfoCompat.getLinkUri());
        if (z) {
            str4 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
        } else {
            str4 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
        }
        bundle3.putInt(str4, i);
        if (z) {
            str5 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
        } else {
            str5 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
        }
        bundle3.putParcelable(str5, bundle);
        if (z) {
            str6 = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
        } else {
            str6 = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
        }
        return inputConnection.performPrivateCommand(str6, bundle3);
    }

    @NonNull
    @Deprecated
    public static InputConnection createWrapper(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull OnCommitContentListener onCommitContentListener) {
        ObjectsCompat.requireNonNull(inputConnection, "inputConnection must be non-null");
        ObjectsCompat.requireNonNull(editorInfo, "editorInfo must be non-null");
        ObjectsCompat.requireNonNull(onCommitContentListener, "onCommitContentListener must be non-null");
        if (Build.VERSION.SDK_INT >= 25) {
            return new C0212a(inputConnection, onCommitContentListener);
        }
        return EditorInfoCompat.getContentMimeTypes(editorInfo).length == 0 ? inputConnection : new C0213b(inputConnection, onCommitContentListener);
    }

    @NonNull
    public static InputConnection createWrapper(@NonNull View view, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        Preconditions.checkNotNull(view);
        return createWrapper(inputConnection, editorInfo, new C1294i5(15, view));
    }
}
