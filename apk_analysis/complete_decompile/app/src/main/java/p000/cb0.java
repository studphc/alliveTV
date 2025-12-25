package p000;

import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.util.Clock;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.net.MediaType;
import java.util.Collection;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final /* synthetic */ class cb0 implements Function {

    /* renamed from: a */
    public final /* synthetic */ int f8314a;

    public /* synthetic */ cb0(int i) {
        this.f8314a = i;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f8314a) {
            case 0:
                return new DefaultAnalyticsCollector((Clock) obj);
            case 1:
                String str = (String) obj;
                if (!MediaType.f15178h.matchesAllOf(str) || str.isEmpty()) {
                    StringBuilder sb = new StringBuilder(str.length() + 16);
                    sb.append(Typography.quote);
                    for (int i = 0; i < str.length(); i++) {
                        char charAt = str.charAt(i);
                        if (charAt == '\r' || charAt == '\\' || charAt == '\"') {
                            sb.append('\\');
                        }
                        sb.append(charAt);
                    }
                    sb.append(Typography.quote);
                    return sb.toString();
                }
                return str;
            case 2:
                return ImmutableMultiset.copyOf((Collection) obj);
            case 3:
                return (Track) obj;
            case 4:
                return new pq1((Map.Entry) obj);
            default:
                return ((Map) obj).keySet().iterator();
        }
    }
}
