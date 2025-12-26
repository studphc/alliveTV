package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m5569d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1963#2,14:135\n*S KotlinDebug\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n*L\n38#1:135,14\n*E\n"})
/* loaded from: classes2.dex */
public final class MainDispatcherLoader {

    @NotNull
    public static final MainDispatcherLoader INSTANCE = new Object();

    @JvmField
    @NotNull
    public static final MainCoroutineDispatcher dispatcher;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlinx.coroutines.internal.MainDispatcherLoader] */
    static {
        Object obj;
        MainCoroutineDispatcher tryCreateDispatcher;
        SystemPropsKt.systemProp("kotlinx.coroutines.fast.service.loader", true);
        List list = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.asSequence(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                do {
                    Object next2 = it.next();
                    int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                    if (loadPriority < loadPriority2) {
                        next = next2;
                        loadPriority = loadPriority2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) obj;
        if (mainDispatcherFactory != null && (tryCreateDispatcher = MainDispatchersKt.tryCreateDispatcher(mainDispatcherFactory, list)) != null) {
            dispatcher = tryCreateDispatcher;
        } else {
            MainDispatchersKt.throwMissingMainDispatcherException();
            throw new KotlinNothingValueException();
        }
    }
}
