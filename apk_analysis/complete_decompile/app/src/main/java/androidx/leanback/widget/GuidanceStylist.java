package androidx.leanback.widget;

import android.animation.Animator;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: classes.dex */
public class GuidanceStylist implements FragmentAnimationProvider {

    /* renamed from: a */
    public TextView f5725a;

    /* renamed from: b */
    public TextView f5726b;

    /* renamed from: c */
    public TextView f5727c;

    /* renamed from: d */
    public ImageView f5728d;

    /* renamed from: e */
    public View f5729e;

    /* loaded from: classes.dex */
    public static class Guidance {

        /* renamed from: a */
        public final String f5730a;

        /* renamed from: b */
        public final String f5731b;

        /* renamed from: c */
        public final String f5732c;

        /* renamed from: d */
        public final Drawable f5733d;

        public Guidance(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Drawable drawable) {
            this.f5732c = str3;
            this.f5730a = str;
            this.f5731b = str2;
            this.f5733d = drawable;
        }

        @Nullable
        public String getBreadcrumb() {
            return this.f5732c;
        }

        @Nullable
        public String getDescription() {
            return this.f5731b;
        }

        @Nullable
        public Drawable getIconDrawable() {
            return this.f5733d;
        }

        @Nullable
        public String getTitle() {
            return this.f5730a;
        }
    }

    @Nullable
    public TextView getBreadcrumbView() {
        return this.f5727c;
    }

    @Nullable
    public TextView getDescriptionView() {
        return this.f5726b;
    }

    @Nullable
    public ImageView getIconView() {
        return this.f5728d;
    }

    @Nullable
    public TextView getTitleView() {
        return this.f5725a;
    }

    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @NonNull Guidance guidance) {
        View inflate = layoutInflater.inflate(onProvideLayoutId(), viewGroup, false);
        this.f5725a = (TextView) inflate.findViewById(androidx.leanback.R.id.guidance_title);
        this.f5727c = (TextView) inflate.findViewById(androidx.leanback.R.id.guidance_breadcrumb);
        this.f5726b = (TextView) inflate.findViewById(androidx.leanback.R.id.guidance_description);
        this.f5728d = (ImageView) inflate.findViewById(androidx.leanback.R.id.guidance_icon);
        this.f5729e = inflate.findViewById(androidx.leanback.R.id.guidance_container);
        TextView textView = this.f5725a;
        if (textView != null) {
            textView.setText(guidance.getTitle());
        }
        TextView textView2 = this.f5727c;
        if (textView2 != null) {
            textView2.setText(guidance.getBreadcrumb());
        }
        TextView textView3 = this.f5726b;
        if (textView3 != null) {
            textView3.setText(guidance.getDescription());
        }
        if (this.f5728d != null) {
            if (guidance.getIconDrawable() != null) {
                this.f5728d.setImageDrawable(guidance.getIconDrawable());
            } else {
                this.f5728d.setVisibility(8);
            }
        }
        View view = this.f5729e;
        if (view != null && TextUtils.isEmpty(view.getContentDescription())) {
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(guidance.getBreadcrumb())) {
                sb.append(guidance.getBreadcrumb());
                sb.append('\n');
            }
            if (!TextUtils.isEmpty(guidance.getTitle())) {
                sb.append(guidance.getTitle());
                sb.append('\n');
            }
            if (!TextUtils.isEmpty(guidance.getDescription())) {
                sb.append(guidance.getDescription());
                sb.append('\n');
            }
            this.f5729e.setContentDescription(sb);
        }
        return inflate;
    }

    public void onDestroyView() {
        this.f5727c = null;
        this.f5726b = null;
        this.f5728d = null;
        this.f5725a = null;
        this.f5729e = null;
    }

    @Override // androidx.leanback.widget.FragmentAnimationProvider
    public void onImeAppearing(@NonNull List<Animator> list) {
    }

    @Override // androidx.leanback.widget.FragmentAnimationProvider
    public void onImeDisappearing(@NonNull List<Animator> list) {
    }

    public int onProvideLayoutId() {
        return androidx.leanback.R.layout.lb_guidance;
    }
}
