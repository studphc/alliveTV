package p000;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.cache.CacheBuilderSpec;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: ak */
/* loaded from: classes.dex */
public abstract class AbstractC0021ak implements InterfaceC1125dk {

    /* renamed from: a */
    public final /* synthetic */ int f233a;

    @Override // p000.InterfaceC1125dk
    /* renamed from: a */
    public final void mo105a(CacheBuilderSpec cacheBuilderSpec, String str, String str2) {
        TimeUnit timeUnit;
        switch (this.f233a) {
            case 0:
                if (!Strings.isNullOrEmpty(str2)) {
                    try {
                        char charAt = str2.charAt(str2.length() - 1);
                        if (charAt != 'd') {
                            if (charAt != 'h') {
                                if (charAt != 'm') {
                                    if (charAt == 's') {
                                        timeUnit = TimeUnit.SECONDS;
                                    } else {
                                        Splitter splitter = CacheBuilderSpec.f14542o;
                                        Locale locale = Locale.ROOT;
                                        throw new IllegalArgumentException("key " + str + " invalid unit: was " + str2 + ", must end with one of [dhms]");
                                    }
                                } else {
                                    timeUnit = TimeUnit.MINUTES;
                                }
                            } else {
                                timeUnit = TimeUnit.HOURS;
                            }
                        } else {
                            timeUnit = TimeUnit.DAYS;
                        }
                        mo106b(cacheBuilderSpec, Long.parseLong(str2.substring(0, str2.length() - 1)), timeUnit);
                        return;
                    } catch (NumberFormatException unused) {
                        Splitter splitter2 = CacheBuilderSpec.f14542o;
                        Locale locale2 = Locale.ROOT;
                        throw new IllegalArgumentException("key " + str + " value set to " + str2 + ", must be integer");
                    }
                }
                throw new IllegalArgumentException(AbstractC1726qj.m7059o("value of key ", str, " omitted", AbstractC1726qj.m7052h(21, str)));
            case 1:
                if (!Strings.isNullOrEmpty(str2)) {
                    try {
                        mo107c(cacheBuilderSpec, Integer.parseInt(str2));
                        return;
                    } catch (NumberFormatException e) {
                        Splitter splitter3 = CacheBuilderSpec.f14542o;
                        Locale locale3 = Locale.ROOT;
                        throw new IllegalArgumentException("key " + str + " value set to " + str2 + ", must be integer", e);
                    }
                }
                throw new IllegalArgumentException(AbstractC1726qj.m7059o("value of key ", str, " omitted", AbstractC1726qj.m7052h(21, str)));
            default:
                if (!Strings.isNullOrEmpty(str2)) {
                    try {
                        mo108d(cacheBuilderSpec, Long.parseLong(str2));
                        return;
                    } catch (NumberFormatException e2) {
                        Splitter splitter4 = CacheBuilderSpec.f14542o;
                        Locale locale4 = Locale.ROOT;
                        throw new IllegalArgumentException("key " + str + " value set to " + str2 + ", must be integer", e2);
                    }
                }
                throw new IllegalArgumentException(AbstractC1726qj.m7059o("value of key ", str, " omitted", AbstractC1726qj.m7052h(21, str)));
        }
    }

    /* renamed from: b */
    public abstract void mo106b(CacheBuilderSpec cacheBuilderSpec, long j, TimeUnit timeUnit);

    /* renamed from: c */
    public abstract void mo107c(CacheBuilderSpec cacheBuilderSpec, int i);

    /* renamed from: d */
    public abstract void mo108d(CacheBuilderSpec cacheBuilderSpec, long j);
}
