package p000;

import android.util.Property;
import androidx.appcompat.widget.SwitchCompat;
import androidx.leanback.graphics.FitWidthBitmapDrawable;

/* loaded from: classes.dex */
public final class je0 extends Property {

    /* renamed from: a */
    public final /* synthetic */ int f20482a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ je0(String str, int i, Class cls) {
        super(cls, str);
        this.f20482a = i;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f20482a) {
            case 0:
                return Integer.valueOf(((FitWidthBitmapDrawable) obj).getVerticalOffset());
            default:
                return Float.valueOf(((SwitchCompat) obj).f1464z);
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f20482a) {
            case 0:
                ((FitWidthBitmapDrawable) obj).setVerticalOffset(((Integer) obj2).intValue());
                return;
            default:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                return;
        }
    }
}
