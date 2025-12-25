package androidx.leanback.app;

import android.animation.PropertyValuesHolder;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.R;
import androidx.leanback.graphics.FitWidthBitmapDrawable;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.widget.DetailsParallaxDrawable;
import androidx.leanback.widget.ParallaxTarget;
import androidx.leanback.widget.VerticalGridView;
import p000.m20;
import p000.n20;
import p000.ou0;

@Deprecated
/* loaded from: classes.dex */
public class DetailsFragmentBackgroundController {

    /* renamed from: a */
    public final DetailsFragment f4925a;

    /* renamed from: b */
    public DetailsParallaxDrawable f4926b;

    /* renamed from: c */
    public int f4927c;

    /* renamed from: d */
    public PlaybackGlue f4928d;

    /* renamed from: e */
    public m20 f4929e;

    /* renamed from: f */
    public Bitmap f4930f;

    /* renamed from: g */
    public int f4931g;

    /* renamed from: h */
    public boolean f4932h = false;

    /* renamed from: i */
    public boolean f4933i = false;

    /* renamed from: j */
    public Fragment f4934j;

    public DetailsFragmentBackgroundController(DetailsFragment detailsFragment) {
        if (detailsFragment.f4919Y == null) {
            detailsFragment.f4919Y = this;
            this.f4925a = detailsFragment;
            return;
        }
        throw new IllegalStateException("Each DetailsFragment is allowed to initialize DetailsFragmentBackgroundController once");
    }

    public boolean canNavigateToVideoFragment() {
        if (this.f4928d != null) {
            return true;
        }
        return false;
    }

    public void enableParallax() {
        int i = this.f4927c;
        if (i == 0) {
            i = ou0.m6729a(this.f4925a).getResources().getDimensionPixelSize(R.dimen.lb_details_cover_drawable_parallax_movement);
        }
        FitWidthBitmapDrawable fitWidthBitmapDrawable = new FitWidthBitmapDrawable();
        enableParallax(fitWidthBitmapDrawable, new ColorDrawable(), new ParallaxTarget.PropertyValuesHolderTarget(fitWidthBitmapDrawable, PropertyValuesHolder.ofInt(FitWidthBitmapDrawable.PROPERTY_VERTICAL_OFFSET, 0, -i)));
    }

    public final Fragment findOrCreateVideoFragment() {
        DetailsFragment detailsFragment = this.f4925a;
        Fragment fragment = detailsFragment.f4912R;
        if (fragment == null) {
            FragmentManager childFragmentManager = detailsFragment.getChildFragmentManager();
            int i = R.id.video_surface_container;
            fragment = childFragmentManager.findFragmentById(i);
            if (fragment == null && detailsFragment.f4919Y != null) {
                FragmentTransaction beginTransaction = detailsFragment.getChildFragmentManager().beginTransaction();
                Fragment onCreateVideoFragment = detailsFragment.f4919Y.onCreateVideoFragment();
                beginTransaction.add(i, onCreateVideoFragment);
                beginTransaction.commit();
                if (detailsFragment.f4920Z) {
                    detailsFragment.getView().post(new n20(detailsFragment, 0));
                }
                fragment = onCreateVideoFragment;
            }
            detailsFragment.f4912R = fragment;
        }
        return fragment;
    }

    public final Drawable getBottomDrawable() {
        DetailsParallaxDrawable detailsParallaxDrawable = this.f4926b;
        if (detailsParallaxDrawable == null) {
            return null;
        }
        return detailsParallaxDrawable.getBottomDrawable();
    }

    public final Bitmap getCoverBitmap() {
        return this.f4930f;
    }

    public final Drawable getCoverDrawable() {
        DetailsParallaxDrawable detailsParallaxDrawable = this.f4926b;
        if (detailsParallaxDrawable == null) {
            return null;
        }
        return detailsParallaxDrawable.getCoverDrawable();
    }

    public final int getParallaxDrawableMaxOffset() {
        return this.f4927c;
    }

    public final PlaybackGlue getPlaybackGlue() {
        return this.f4928d;
    }

    @ColorInt
    public final int getSolidColor() {
        return this.f4931g;
    }

    public PlaybackGlueHost onCreateGlueHost() {
        return new VideoFragmentGlueHost((VideoFragment) findOrCreateVideoFragment());
    }

    public Fragment onCreateVideoFragment() {
        return new VideoFragment();
    }

    public final void setCoverBitmap(Bitmap bitmap) {
        this.f4930f = bitmap;
        Drawable coverDrawable = getCoverDrawable();
        if (coverDrawable instanceof FitWidthBitmapDrawable) {
            ((FitWidthBitmapDrawable) coverDrawable).setBitmap(this.f4930f);
        }
    }

    public final void setParallaxDrawableMaxOffset(int i) {
        if (this.f4926b == null) {
            this.f4927c = i;
            return;
        }
        throw new IllegalStateException("enableParallax already called");
    }

    public final void setSolidColor(@ColorInt int i) {
        this.f4931g = i;
        Drawable bottomDrawable = getBottomDrawable();
        if (bottomDrawable instanceof ColorDrawable) {
            ((ColorDrawable) bottomDrawable).setColor(i);
        }
    }

    public void setupVideoPlayback(@NonNull PlaybackGlue playbackGlue) {
        PlaybackGlue playbackGlue2 = this.f4928d;
        if (playbackGlue2 == playbackGlue) {
            return;
        }
        PlaybackGlueHost playbackGlueHost = null;
        if (playbackGlue2 != null) {
            PlaybackGlueHost host = playbackGlue2.getHost();
            this.f4928d.setHost(null);
            playbackGlueHost = host;
        }
        this.f4928d = playbackGlue;
        m20 m20Var = this.f4929e;
        PlaybackGlue playbackGlue3 = m20Var.f22775f;
        if (playbackGlue3 != null) {
            playbackGlue3.removePlayerCallback(m20Var.f22777h);
        }
        m20Var.f22775f = playbackGlue;
        m20Var.m6008a();
        if (this.f4932h && this.f4928d != null) {
            if (playbackGlueHost != null && this.f4934j == findOrCreateVideoFragment()) {
                this.f4928d.setHost(playbackGlueHost);
                return;
            }
            PlaybackGlue playbackGlue4 = this.f4928d;
            PlaybackGlueHost onCreateGlueHost = onCreateGlueHost();
            if (this.f4933i) {
                onCreateGlueHost.showControlsOverlay(false);
            } else {
                onCreateGlueHost.hideControlsOverlay(false);
            }
            playbackGlue4.setHost(onCreateGlueHost);
            this.f4934j = findOrCreateVideoFragment();
        }
    }

    public final void switchToRows() {
        DetailsFragment detailsFragment = this.f4925a;
        detailsFragment.f4920Z = false;
        VerticalGridView m1287c = detailsFragment.m1287c();
        if (m1287c != null && m1287c.getChildCount() > 0) {
            m1287c.requestFocus();
        }
    }

    public final void switchToVideo() {
        DetailsFragment detailsFragment = this.f4925a;
        Fragment fragment = detailsFragment.f4912R;
        if (fragment != null && fragment.getView() != null) {
            detailsFragment.f4912R.getView().requestFocus();
        } else {
            detailsFragment.f4754w.fireEvent(detailsFragment.f4906L);
        }
    }

    public void enableParallax(@NonNull Drawable drawable, @NonNull Drawable drawable2, @Nullable ParallaxTarget.PropertyValuesHolderTarget propertyValuesHolderTarget) {
        if (this.f4926b != null) {
            return;
        }
        Bitmap bitmap = this.f4930f;
        if (bitmap != null && (drawable instanceof FitWidthBitmapDrawable)) {
            ((FitWidthBitmapDrawable) drawable).setBitmap(bitmap);
        }
        int i = this.f4931g;
        if (i != 0 && (drawable2 instanceof ColorDrawable)) {
            ((ColorDrawable) drawable2).setColor(i);
        }
        if (this.f4928d == null) {
            DetailsFragment detailsFragment = this.f4925a;
            DetailsParallaxDrawable detailsParallaxDrawable = new DetailsParallaxDrawable(ou0.m6729a(detailsFragment), detailsFragment.getParallax(), drawable, drawable2, propertyValuesHolderTarget);
            this.f4926b = detailsParallaxDrawable;
            View view = detailsFragment.f4910P;
            if (view != null) {
                view.setBackground(detailsParallaxDrawable);
            }
            detailsFragment.f4911Q = detailsParallaxDrawable;
            this.f4929e = new m20(detailsFragment.getParallax(), this.f4926b.getCoverDrawable());
            return;
        }
        throw new IllegalStateException("enableParallaxDrawable must be called before enableVideoPlayback");
    }
}
