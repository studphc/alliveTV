package p000;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.eventbus.Subscribe;
import com.google.common.primitives.Primitives;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class bq2 extends CacheLoader {
    @Override // com.google.common.cache.CacheLoader
    public final Object load(Object obj) {
        boolean z;
        Set rawTypes = TypeToken.m4293of((Class) obj).getTypes().rawTypes();
        HashMap newHashMap = Maps.newHashMap();
        Iterator it = rawTypes.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (method.isAnnotationPresent(Subscribe.class) && !method.isSynthetic()) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkArgument(z, "Method %s has @Subscribe annotation but has %s parameters. Subscriber methods must have exactly 1 parameter.", (Object) method, parameterTypes.length);
                    Preconditions.checkArgument(!parameterTypes[0].isPrimitive(), "@Subscribe method %s's parameter is %s. Subscriber methods cannot accept primitives. Consider changing the parameter to %s.", method, parameterTypes[0].getName(), Primitives.wrap(parameterTypes[0]).getSimpleName());
                    dq2 dq2Var = new dq2(method);
                    if (!newHashMap.containsKey(dq2Var)) {
                        newHashMap.put(dq2Var, method);
                    }
                }
            }
        }
        return ImmutableList.copyOf(newHashMap.values());
    }
}
