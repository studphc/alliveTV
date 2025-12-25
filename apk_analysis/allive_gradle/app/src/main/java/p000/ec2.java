package p000;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* loaded from: classes.dex */
public final class ec2 {

    /* renamed from: a */
    public final ColorStateList f16759a;

    /* renamed from: b */
    public final Configuration f16760b;

    /* renamed from: c */
    public final int f16761c;

    public ec2(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        int hashCode;
        this.f16759a = colorStateList;
        this.f16760b = configuration;
        if (theme == null) {
            hashCode = 0;
        } else {
            hashCode = theme.hashCode();
        }
        this.f16761c = hashCode;
    }
}
