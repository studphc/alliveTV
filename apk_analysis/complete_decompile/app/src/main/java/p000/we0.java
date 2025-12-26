package p000;

import androidx.emoji2.text.flatbuffer.FlexBuffersBuilder;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class we0 implements Comparator {

    /* renamed from: a */
    public final /* synthetic */ int f28158a;

    /* renamed from: b */
    public final /* synthetic */ Object f28159b;

    public /* synthetic */ we0(int i, Object obj) {
        this.f28158a = i;
        this.f28159b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        byte b;
        byte b2;
        switch (this.f28158a) {
            case 0:
                int i = ((xe0) obj).f28522e;
                int i2 = ((xe0) obj2).f28522e;
                do {
                    FlexBuffersBuilder flexBuffersBuilder = (FlexBuffersBuilder) this.f28159b;
                    b = flexBuffersBuilder.f4275a.get(i);
                    b2 = flexBuffersBuilder.f4275a.get(i2);
                    if (b != 0) {
                        i++;
                        i2++;
                    }
                    return b - b2;
                } while (b == b2);
                return b - b2;
            default:
                Map.Entry entry = (Map.Entry) obj;
                Map.Entry entry2 = (Map.Entry) obj2;
                Objects.requireNonNull(entry);
                Objects.requireNonNull(entry2);
                return ((Comparator) this.f28159b).compare(entry.getKey(), entry2.getKey());
        }
    }
}
