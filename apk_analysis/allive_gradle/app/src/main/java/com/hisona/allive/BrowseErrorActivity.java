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
import com.google.android.exoplayer2.C0643C;
import p000.RunnableC0006a5;

/* loaded from: classes2.dex */
public class BrowseErrorActivity extends FragmentActivity {

    /* renamed from: E */
    public static final /* synthetic */ int f15797E = 0;

    /* renamed from: C */
    public ErrorFragment f15798C;

    /* renamed from: D */
    public SpinnerFragment f15799D;

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
        this.f15798C = new ErrorFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_browse_fragment, this.f15798C).commit();
        this.f15799D = new SpinnerFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_browse_fragment, this.f15799D).commit();
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0006a5(2, this), C0643C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }
}
