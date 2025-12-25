package com.hisona.allive;

import android.os.Bundle;
import androidx.leanback.app.ErrorSupportFragment;

/* loaded from: classes2.dex */
public class ErrorFragment extends ErrorSupportFragment {
    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(getResources().getString(R.string.browse_title));
    }
}
