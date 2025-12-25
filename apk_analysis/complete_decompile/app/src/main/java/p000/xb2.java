package p000;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public final class xb2 implements ac2 {

    /* renamed from: a */
    public final /* synthetic */ int f28499a;

    public /* synthetic */ xb2(int i) {
        this.f28499a = i;
    }

    @Override // p000.ac2
    /* renamed from: a */
    public final Drawable mo62a(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
        switch (this.f28499a) {
            case 0:
                try {
                    return AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlResourceParser, attributeSet, theme);
                } catch (Exception e) {
                    Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                    return null;
                }
            case 1:
                try {
                    return AnimatedVectorDrawableCompat.createFromXmlInner(context, context.getResources(), xmlResourceParser, attributeSet, theme);
                } catch (Exception e2) {
                    Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                    return null;
                }
            default:
                try {
                    return VectorDrawableCompat.createFromXmlInner(context.getResources(), (XmlPullParser) xmlResourceParser, attributeSet, theme);
                } catch (Exception e3) {
                    Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e3);
                    return null;
                }
        }
    }
}
