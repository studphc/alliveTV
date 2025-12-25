package p000;

import android.graphics.Color;
import androidx.annotation.DoNotInline;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

/* renamed from: nq */
/* loaded from: classes.dex */
public abstract class AbstractC1594nq {
    @DoNotInline
    /* renamed from: a */
    public static Color m6393a(Color color, Color color2) {
        if (Objects.equals(color.getModel(), color2.getModel())) {
            if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                color = color.convert(color2.getColorSpace());
            }
            float[] components = color.getComponents();
            float[] components2 = color2.getComponents();
            float alpha = color.alpha();
            float alpha2 = (1.0f - alpha) * color2.alpha();
            int componentCount = color2.getComponentCount() - 1;
            float f = alpha + alpha2;
            components2[componentCount] = f;
            if (f > RecyclerView.f7068F0) {
                alpha /= f;
                alpha2 /= f;
            }
            for (int i = 0; i < componentCount; i++) {
                components2[i] = (components2[i] * alpha2) + (components[i] * alpha);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
        throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
    }
}
