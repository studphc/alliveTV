package p000;

import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.widget.TextView;

/* renamed from: ja */
/* loaded from: classes.dex */
public class C1347ja extends AbstractC1504la {
    @Override // p000.AbstractC1504la
    /* renamed from: a */
    public void mo5423a(StaticLayout.Builder builder, TextView textView) {
        builder.setTextDirection((TextDirectionHeuristic) C1541ma.m6115e(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
    }
}
