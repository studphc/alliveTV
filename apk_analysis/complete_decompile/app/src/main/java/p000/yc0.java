package p000;

import com.google.common.collect.Lists;
import com.google.common.io.LineProcessor;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class yc0 implements LineProcessor {

    /* renamed from: a */
    public final /* synthetic */ int f28895a;

    /* renamed from: b */
    public final ArrayList f28896b;

    public yc0(int i) {
        this.f28895a = i;
        switch (i) {
            case 1:
                this.f28896b = Lists.newArrayList();
                return;
            default:
                this.f28896b = Lists.newArrayList();
                return;
        }
    }

    @Override // com.google.common.io.LineProcessor
    public final Object getResult() {
        switch (this.f28895a) {
            case 0:
                return this.f28896b;
            default:
                return this.f28896b;
        }
    }

    @Override // com.google.common.io.LineProcessor
    public final boolean processLine(String str) {
        switch (this.f28895a) {
            case 0:
                this.f28896b.add(str);
                return true;
            default:
                this.f28896b.add(str);
                return true;
        }
    }
}
