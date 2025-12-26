package p000;

import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.common.base.Function;
import com.google.common.escape.Escaper;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final /* synthetic */ class z90 implements Function {

    /* renamed from: a */
    public final /* synthetic */ int f29291a;

    /* renamed from: b */
    public final /* synthetic */ Object f29292b;

    public /* synthetic */ z90(int i, Object obj) {
        this.f29291a = i;
        this.f29292b = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f29291a) {
            case 0:
                return ((Escaper) this.f29292b).escape((String) obj);
            case 1:
                return (AnalyticsCollector) this.f29292b;
            case 2:
                return ((FragmentedMp4Extractor) this.f29292b).modifyTrack((Track) obj);
            default:
                return ((gz2) this.f29292b).mo4650b((Type) obj);
        }
    }
}
