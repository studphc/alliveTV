package androidx.leanback.app;

import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.R;
import androidx.leanback.graphics.FitWidthBitmapDrawable;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.widget.DetailsParallaxDrawable;
import androidx.leanback.widget.ParallaxTarget;
import androidx.leanback.widget.VerticalGridView;
import p000.e30;
import p000.m20;

/* loaded from: classes.dex */
public class DetailsSupportFragmentBackgroundController {

    /* renamed from: a */
    public final DetailsSupportFragment f4965a;

    /* renamed from: b */
    public DetailsParallaxDrawable f4966b;

    /* renamed from: c */
    public int f4967c;

    /* renamed from: d */
    public PlaybackGlue f4968d;

    /* renamed from: e */
    public m20 f4969e;

    /* renamed from: f */
    public Bitmap f4970f;

    /* renamed from: g */
    public int f4971g;

    /* renamed from: h */
    public boolean f4972h = false;

    /* renamed from: i */
    public boolean f4973i = false;

    /* renamed from: j */
    public Fragment f4974j;

    public DetailsSupportFragmentBackgroundController(DetailsSupportFragment detailsSupportFragment) {
        if (detailsSupportFragment.f4960c1 == null) {
            detailsSupportFragment.f4960c1 = this;
            this.f4965a = detailsSupportFragment;
            return;
        }
        throw new IllegalStateException("Each DetailsSupportFragment is allowed to initialize DetailsSupportFragmentBackgroundController once");
    }

    public boolean canNavigateToVideoSupportFragment() {
        if (this.f4968d != null) {
            return true;
        }
        return false;
    }

    public void enableParallax() {
        int i = this.f4967c;
        if (i == 0) {
            i = this.f4965a.getContext().getResources().getDimensionPixelSize(R.dimen.lb_details_cover_drawable_parallax_movement);
        }
        FitWidthBitmapDrawable fitWidthBitmapDrawable = new FitWidthBitmapDrawable();
        enableParallax(fitWidthBitmapDrawable, new ColorDrawable(), new ParallaxTarget.PropertyValuesHolderTarget(fitWidthBitmapDrawable, PropertyValuesHolder.ofInt(FitWidthBitmapDrawable.PROPERTY_VERTICAL_OFFSET, 0, -i)));
    }

    public final Fragment findOrCreateVideoSupportFragment() {
        DetailsSupportFragment detailsSupportFragment = this.f4965a;
        Fragment fragment = detailsSupportFragment.f4953V0;
        if (fragment == null) {
            FragmentManager childFragmentManager = detailsSupportFragment.getChildFragmentManager();
            int i = R.id.video_surface_container;
            fragment = childFragmentManager.findFragmentById(i);
            if (fragment == null && detailsSupportFragment.f4960c1 != null) {
                FragmentTransaction beginTransaction = detailsSupportFragment.getChildFragmentManager().beginTransaction();
                Fragment onCreateVideoSupportFragment = detailsSupportFragment.f4960c1.onCreateVideoSupportFragment();
                beginTransaction.add(i, onCreateVideoSupportFragment);
                beginTransaction.commit();
                if (detailsSupportFragment.f4961d1) {
                    detailsSupportFragment.getView().post(new e30(detailsSupportFragment, 0));
                }
                fragment = onCreateVideoSupportFragment;
            }
            detailsSupportFragment.f4953V0 = fragment;
        }
        return fragment;
    }

    public final Drawable getBottomDrawable() {
        DetailsParallaxDrawable detailsParallaxDrawable = this.f4966b;
        if (detailsParallaxDrawable == null) {
            return null;
        }
        return detailsParallaxDrawable.getBottomDrawable();
    }

    public final Bitmap getCoverBitmap() {
        return this.f4970f;
    }

    public final Drawable getCoverDrawable() {
        DetailsParallaxDrawable detailsParallaxDrawable = this.f4966b;
        if (detailsParallaxDrawable == null) {
            return null;
        }
        return detailsParallaxDrawable.getCoverDrawable();
    }

    public final int getParallaxDrawableMaxOffset() {
        return this.f4967c;
    }

    public final PlaybackGlue getPlaybackGlue() {
        return this.f4968d;
    }

    @ColorInt
    public final int getSolidColor() {
        return this.f4971g;
    }

    public PlaybackGlueHost onCreateGlueHost() {
        return new VideoSupportFragmentGlueHost((VideoSupportFragment) findOrCreateVideoSupportFragment());
    }

    public Fragment onCreateVideoSupportFragment() {
        return new VideoSupportFragment();
    }

    public final void setCoverBitmap(Bitmap bitmap) {
        this.f4970f = bitmap;
        Drawable coverDrawable = getCoverDrawable();
        if (coverDrawable instanceof FitWidthBitmapDrawable) {
            ((FitWidthBitmapDrawable) coverDrawable).setBitmap(this.f4970f);
        }
    }

    public final void setParallaxDrawableMaxOffset(int i) {
        if (this.f4966b == null) {
            this.f4967c = i;
            return;
        }
        throw new IllegalStateException("enableParallax already called");
    }

    public final void setSolidColor(@ColorInt int i) {
        this.f4971g = i;
        Drawable bottomDrawable = getBottomDrawable();
        if (bottomDrawable instanceof ColorDrawable) {
            ((ColorDrawable) bottomDrawable).setColor(i);
        }
    }

    public void setupVideoPlayback(@NonNull PlaybackGlue playbackGlue) {
        PlaybackGlue playbackGlue2 = this.f4968d;
        if (playbackGlue2 == playbackGlue) {
            return;
        }
        PlaybackGlueHost playbackGlueHost = null;
        if (playbackGlue2 != null) {
            PlaybackGlueHost host = playbackGlue2.getHost();
            this.f4968d.setHost(null);
            playbackGlueHost = host;
        }
        this.f4968d = playbackGlue;
        m20 m20Var = this.f4969e;
        PlaybackGlue playbackGlue3 = m20Var.f22775f;
        if (playbackGlue3 != null) {
            playbackGlue3.removePlayerCallback(m20Var.f22777h);
        }
        m20Var.f22775f = playbackGlue;
        m20Var.m6008a();
        if (this.f4972h && this.f4968d != null) {
            if (playbackGlueHost != null && this.f4974j == findOrCreateVideoSupportFragment()) {
                this.f4968d.setHost(playbackGlueHost);
                return;
            }
            PlaybackGlue playbackGlue4 = this.f4968d;
            PlaybackGlueHost onCreateGlueHost = onCreateGlueHost();
            if (this.f4973i) {
                onCreateGlueHost.showControlsOverlay(false);
            } else {
                onCreateGlueHost.hideControlsOverlay(false);
            }
            playbackGlue4.setHost(onCreateGlueHost);
            this.f4974j = findOrCreateVideoSupportFragment();
        }
    }

    public final void switchToRows() {
        DetailsSupportFragment detailsSupportFragment = this.f4965a;
        detailsSupportFragment.f4961d1 = false;
        VerticalGridView verticalGridView = detailsSupportFragment.getVerticalGridView();
        if (verticalGridView != null && verticalGridView.getChildCount() > 0) {
            verticalGridView.requestFocus();
        }
    }

    public final void switchToVideo() {
        DetailsSupportFragment detailsSupportFragment = this.f4965a;
        Fragment fragment = detailsSupportFragment.f4953V0;
        if (fragment != null && fragment.getView() != null) {
            detailsSupportFragment.f4953V0.getView().requestFocus();
        } else {
            detailsSupportFragment.f4757A0.fireEvent(detailsSupportFragment.f4947P0);
        }
    }

    public void enableParallax(@NonNull Drawable drawable, @NonNull Drawable drawable2, @Nullable ParallaxTarget.PropertyValuesHolderTarget propertyValuesHolderTarget) {
        if (this.f4966b != null) {
            return;
        }
        Bitmap bitmap = this.f4970f;
        if (bitmap != null && (drawable instanceof FitWidthBitmapDrawable)) {
            ((FitWidthBitmapDrawable) drawable).setBitmap(bitmap);
        }
        int i = this.f4971g;
        if (i != 0 && (drawable2 instanceof ColorDrawable)) {
            ((ColorDrawable) drawable2).setColor(i);
        }
        if (this.f4968d == null) {
            DetailsSupportFragment detailsSupportFragment = this.f4965a;
            DetailsParallaxDrawable detailsParallaxDrawable = new DetailsParallaxDrawable(detailsSupportFragment.getContext(), detailsSupportFragment.getParallax(), drawable, drawable2, propertyValuesHolderTarget);
            this.f4966b = detailsParallaxDrawable;
            View view = detailsSupportFragment.f4951T0;
            if (view != null) {
                view.setBackground(detailsParallaxDrawable);
            }
            detailsSupportFragment.f4952U0 = detailsParallaxDrawable;
            this.f4969e = new m20(detailsSupportFragment.getParallax(), this.f4966b.getCoverDrawable());
            return;
        }
        throw new IllegalStateException("enableParallaxDrawable must be called before enableVideoPlayback");
    }
}
