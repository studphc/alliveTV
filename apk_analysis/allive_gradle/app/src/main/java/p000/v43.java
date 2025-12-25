package p000;

import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.CtorCache;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;

/* loaded from: classes2.dex */
public final class v43 extends CtorCache {

    /* renamed from: a */
    public static final v43 f27649a = new CtorCache();

    /* renamed from: b */
    public static final ReentrantReadWriteLock f27650b = new ReentrantReadWriteLock();

    /* renamed from: c */
    public static final WeakHashMap f27651c = new WeakHashMap();

    @Override // kotlinx.coroutines.internal.CtorCache
    public final Function1 get(Class cls) {
        int i;
        ReentrantReadWriteLock reentrantReadWriteLock = f27650b;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        WeakHashMap weakHashMap = f27651c;
        try {
            Function1 function1 = (Function1) weakHashMap.get(cls);
            if (function1 != null) {
                return function1;
            }
            ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
            int i2 = 0;
            if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                i = reentrantReadWriteLock.getReadHoldCount();
            } else {
                i = 0;
            }
            for (int i3 = 0; i3 < i; i3++) {
                readLock2.unlock();
            }
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            writeLock.lock();
            try {
                Function1 function12 = (Function1) weakHashMap.get(cls);
                if (function12 != null) {
                    return function12;
                }
                Function1 access$createConstructor = ExceptionsConstructorKt.access$createConstructor(cls);
                weakHashMap.put(cls, access$createConstructor);
                while (i2 < i) {
                    readLock2.lock();
                    i2++;
                }
                writeLock.unlock();
                return access$createConstructor;
            } finally {
                while (i2 < i) {
                    readLock2.lock();
                    i2++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }
}
