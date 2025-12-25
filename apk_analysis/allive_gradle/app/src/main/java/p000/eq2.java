package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.EventBus;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class eq2 {

    /* renamed from: c */
    public static final LoadingCache f16951c = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<>());

    /* renamed from: d */
    public static final LoadingCache f16952d = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<>());

    /* renamed from: a */
    public final ConcurrentMap f16953a = Maps.newConcurrentMap();

    /* renamed from: b */
    public final EventBus f16954b;

    public eq2(EventBus eventBus) {
        this.f16954b = (EventBus) Preconditions.checkNotNull(eventBus);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public final HashMultimap m4749a(Object obj) {
        aq2 aq2Var;
        HashMultimap create = HashMultimap.create();
        try {
            UnmodifiableIterator it = ((ImmutableList) f16951c.getUnchecked(obj.getClass())).iterator();
            while (it.hasNext()) {
                Method method = (Method) it.next();
                Class<?> cls = method.getParameterTypes()[0];
                Annotation annotation = method.getAnnotation(AllowConcurrentEvents.class);
                EventBus eventBus = this.f16954b;
                if (annotation != null) {
                    aq2Var = new aq2(eventBus, obj, method);
                } else {
                    aq2Var = new aq2(eventBus, obj, method);
                }
                create.put(cls, aq2Var);
            }
            return create;
        } catch (UncheckedExecutionException e) {
            Throwables.throwIfUnchecked(e.getCause());
            throw e;
        }
    }
}
