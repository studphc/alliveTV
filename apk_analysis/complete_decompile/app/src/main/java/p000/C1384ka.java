package p000;

import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.widget.TextView;

/* renamed from: ka */
/* loaded from: classes.dex */
public final class C1384ka extends C1347ja {
    @Override // p000.C1347ja, p000.AbstractC1504la
    /* renamed from: a */
    public void mo5423a(StaticLayout.Builder builder, TextView textView) {
        TextDirectionHeuristic textDirectionHeuristic;
        textDirectionHeuristic = textView.getTextDirectionHeuristic();
        builder.setTextDirection(textDirectionHeuristic);
    }

    @Override // p000.AbstractC1504la
    /* renamed from: b */
    public boolean mo5515b(TextView textView) {
        boolean isHorizontallyScrollable;
        isHorizontallyScrollable = textView.isHorizontallyScrollable();
        return isHorizontallyScrollable;
    }
}
