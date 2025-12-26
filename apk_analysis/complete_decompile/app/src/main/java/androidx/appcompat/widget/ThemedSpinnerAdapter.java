package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;

/* loaded from: classes.dex */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    /* loaded from: classes.dex */
    public static final class Helper {

        /* renamed from: a */
        public final Context f1486a;

        /* renamed from: b */
        public final LayoutInflater f1487b;

        /* renamed from: c */
        public LayoutInflater f1488c;

        public Helper(@NonNull Context context) {
            this.f1486a = context;
            this.f1487b = LayoutInflater.from(context);
        }

        @NonNull
        public LayoutInflater getDropDownViewInflater() {
            LayoutInflater layoutInflater = this.f1488c;
            if (layoutInflater == null) {
                return this.f1487b;
            }
            return layoutInflater;
        }

        @Nullable
        public Resources.Theme getDropDownViewTheme() {
            LayoutInflater layoutInflater = this.f1488c;
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.getContext().getTheme();
        }

        public void setDropDownViewTheme(@Nullable Resources.Theme theme) {
            if (theme == null) {
                this.f1488c = null;
                return;
            }
            Context context = this.f1486a;
            if (theme.equals(context.getTheme())) {
                this.f1488c = this.f1487b;
            } else {
                this.f1488c = LayoutInflater.from(new ContextThemeWrapper(context, theme));
            }
        }
    }

    @Nullable
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@Nullable Resources.Theme theme);
}
