package com.hisona.allive;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.C;
import defpackage.a5;

/* loaded from: classes2.dex */
public class BrowseErrorActivity extends FragmentActivity {
    public static final /* synthetic */ int E = 0;
    public ErrorFragment C;
    public SpinnerFragment D;

    /* loaded from: classes2.dex */
    public static class SpinnerFragment extends Fragment {
        @Override // androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            ProgressBar progressBar = new ProgressBar(viewGroup.getContext());
            if (viewGroup instanceof FrameLayout) {
                progressBar.setLayoutParams(new FrameLayout.LayoutParams(100, 100, 17));
            }
            return progressBar;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.C = new ErrorFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_browse_fragment, this.C).commit();
        this.D = new SpinnerFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_browse_fragment, this.D).commit();
        new Handler(Looper.getMainLooper()).postDelayed(new a5(2, this), C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }
}
