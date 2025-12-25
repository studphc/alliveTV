package com.hisona.allive;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import defpackage.q12;

/* loaded from: classes2.dex */
public class SpinnerFragment extends Fragment {
    @Override // androidx.fragment.app.Fragment
    @RequiresApi(api = 29)
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BlendMode blendMode;
        ProgressBar progressBar = new ProgressBar(viewGroup.getContext());
        if (viewGroup instanceof FrameLayout) {
            progressBar.setLayoutParams(new FrameLayout.LayoutParams(100, 100, 17));
            if (Build.VERSION.SDK_INT >= 29) {
                Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
                q12.j();
                int color = ContextCompat.getColor(getContext(), R.color.selected_background);
                blendMode = BlendMode.MODULATE;
                indeterminateDrawable.setColorFilter(q12.h(color, blendMode));
            } else {
                progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getContext(), R.color.selected_background), PorterDuff.Mode.MULTIPLY);
            }
        }
        return progressBar;
    }
}
