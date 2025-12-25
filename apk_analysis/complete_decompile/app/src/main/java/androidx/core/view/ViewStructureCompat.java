package androidx.core.view;

import android.view.ViewStructure;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p000.x33;

/* loaded from: classes.dex */
public class ViewStructureCompat {

    /* renamed from: a */
    public final ViewStructure f3934a;

    public ViewStructureCompat(ViewStructure viewStructure) {
        this.f3934a = viewStructure;
    }

    @NonNull
    @RequiresApi(23)
    public static ViewStructureCompat toViewStructureCompat(@NonNull ViewStructure viewStructure) {
        return new ViewStructureCompat(viewStructure);
    }

    public void setClassName(@NonNull String str) {
        x33.m8094a(this.f3934a, str);
    }

    public void setContentDescription(@NonNull CharSequence charSequence) {
        x33.m8095b(this.f3934a, charSequence);
    }

    public void setDimens(int i, int i2, int i3, int i4, int i5, int i6) {
        x33.m8096c(this.f3934a, i, i2, i3, i4, i5, i6);
    }

    public void setText(@NonNull CharSequence charSequence) {
        x33.m8097d(this.f3934a, charSequence);
    }

    @NonNull
    @RequiresApi(23)
    public ViewStructure toViewStructure() {
        return this.f3934a;
    }
}
