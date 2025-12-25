package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;
import p000.ha0;
import p000.q63;
import p000.r63;
import p000.s63;

@Metadata(m5568d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m5569d2 = {"collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", "path", "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", FirebaseAnalytics.Param.SOURCE, TypedValues.AttributesType.S_TARGET, "commonCreateDirectories", "dir", "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio"}, m5570k = 2, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class _FileSystemKt {
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c8, code lost:
    
        if (r0 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ca, code lost:
    
        if (r11 != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cc, code lost:
    
        r6.addLast(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d3, code lost:
    
        r11 = r10;
        r10 = r3;
        r14 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r7.iterator();
        r7 = r6;
        r6 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0112, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0113, code lost:
    
        r7 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v6, types: [kotlin.sequences.SequenceScope] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r15v0, types: [kotlin.sequences.SequenceScope<? super okio.Path>, kotlin.sequences.SequenceScope] */
    /* JADX WARN: Type inference failed for: r4v2, types: [kotlin.coroutines.Continuation, q63] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object collectRecursively(@NotNull SequenceScope<? super Path> sequenceScope, @NotNull FileSystem fileSystem, @NotNull ArrayDeque<Path> arrayDeque, @NotNull Path path, boolean z, boolean z2, @NotNull Continuation<? super Unit> continuation) {
        Continuation continuation2;
        int i;
        FileSystem fileSystem2;
        ArrayDeque<Path> arrayDeque2;
        boolean z3;
        ?? r10;
        boolean z4;
        List<Path> listOrNull;
        Path path2 = path;
        boolean z5 = z2;
        if (continuation instanceof q63) {
            q63 q63Var = (q63) continuation;
            int i2 = q63Var.f25472l;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                q63Var.f25472l = i2 - Integer.MIN_VALUE;
                continuation2 = q63Var;
                Object obj = continuation2.f25471k;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = continuation2.f25472l;
                if (i == 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        boolean z6 = continuation2.f25470j;
                        boolean z7 = continuation2.f25469i;
                        Iterator<Path> it = continuation2.f25468h;
                        Path path3 = continuation2.f25467g;
                        ArrayDeque<Path> arrayDeque3 = continuation2.f25466f;
                        FileSystem fileSystem3 = continuation2.f25465e;
                        SequenceScope sequenceScope2 = continuation2.f25464d;
                        try {
                            ResultKt.throwOnFailure(obj);
                            while (it.hasNext()) {
                                Path next = it.next();
                                continuation2.f25464d = sequenceScope2;
                                continuation2.f25465e = fileSystem3;
                                continuation2.f25466f = arrayDeque3;
                                continuation2.f25467g = path3;
                                continuation2.f25468h = it;
                                continuation2.f25469i = z7;
                                continuation2.f25470j = z6;
                                continuation2.f25472l = 2;
                                if (collectRecursively(sequenceScope2, fileSystem3, arrayDeque3, next, z7, z6, continuation2) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            arrayDeque3.removeLast();
                            z5 = z6;
                            path2 = path3;
                            r10 = sequenceScope2;
                            if (z5) {
                                continuation2.f25464d = null;
                                continuation2.f25465e = null;
                                continuation2.f25466f = null;
                                continuation2.f25467g = null;
                                continuation2.f25468h = null;
                                continuation2.f25472l = 3;
                                if (r10.yield(path2, continuation2) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th) {
                            th = th;
                            arrayDeque3.removeLast();
                            throw th;
                        }
                    }
                    boolean z8 = continuation2.f25470j;
                    boolean z9 = continuation2.f25469i;
                    Path path4 = continuation2.f25467g;
                    arrayDeque2 = continuation2.f25466f;
                    FileSystem fileSystem4 = continuation2.f25465e;
                    SequenceScope sequenceScope3 = continuation2.f25464d;
                    ResultKt.throwOnFailure(obj);
                    fileSystem2 = fileSystem4;
                    z5 = z8;
                    z4 = z9;
                    path2 = path4;
                    r10 = sequenceScope3;
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (!z5) {
                        continuation2.f25464d = sequenceScope;
                        fileSystem2 = fileSystem;
                        continuation2.f25465e = fileSystem2;
                        arrayDeque2 = arrayDeque;
                        continuation2.f25466f = arrayDeque2;
                        continuation2.f25467g = path2;
                        z3 = z;
                        continuation2.f25469i = z3;
                        continuation2.f25470j = z5;
                        continuation2.f25472l = 1;
                        if (sequenceScope.yield(path2, continuation2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        fileSystem2 = fileSystem;
                        arrayDeque2 = arrayDeque;
                        z3 = z;
                    }
                    boolean z10 = z3;
                    r10 = sequenceScope;
                    z4 = z10;
                }
                listOrNull = fileSystem2.listOrNull(path2);
                if (listOrNull == null) {
                    listOrNull = CollectionsKt__CollectionsKt.emptyList();
                }
                if (!listOrNull.isEmpty()) {
                    int i3 = 0;
                    Path path5 = path2;
                    while (true) {
                        if (z4 && arrayDeque2.contains(path5)) {
                            throw new IOException("symlink cycle at " + path2);
                        }
                        Path symlinkTarget = symlinkTarget(fileSystem2, path5);
                        if (symlinkTarget == null) {
                            break;
                        }
                        i3++;
                        path5 = symlinkTarget;
                    }
                }
                if (z5) {
                }
            }
        }
        continuation2 = new ContinuationImpl(continuation);
        Object obj2 = continuation2.f25471k;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = continuation2.f25472l;
        if (i == 0) {
        }
        listOrNull = fileSystem2.listOrNull(path2);
        if (listOrNull == null) {
        }
        if (!listOrNull.isEmpty()) {
        }
        if (z5) {
        }
    }

    public static final void commonCopy(@NotNull FileSystem fileSystem, @NotNull Path source, @NotNull Path target) {
        Long l;
        Long l2;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Source source2 = fileSystem.source(source);
        Throwable th = null;
        try {
            BufferedSink buffer = Okio.buffer(fileSystem.sink(target));
            try {
                l2 = Long.valueOf(buffer.writeAll(source2));
                th = null;
            } catch (Throwable th2) {
                th = th2;
                l2 = null;
            }
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    } else {
                        ha0.addSuppressed(th, th3);
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            l = null;
        }
        if (th == null) {
            Intrinsics.checkNotNull(l2);
            l = Long.valueOf(l2.longValue());
            if (source2 != null) {
                try {
                    source2.close();
                } catch (Throwable th5) {
                    if (th == null) {
                        th = th5;
                    } else {
                        ha0.addSuppressed(th, th5);
                    }
                }
            }
            if (th == null) {
                Intrinsics.checkNotNull(l);
                return;
            }
            throw th;
        }
        throw th;
    }

    public static final void commonCreateDirectories(@NotNull FileSystem fileSystem, @NotNull Path dir, boolean z) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Path path = dir; path != null && !fileSystem.exists(path); path = path.parent()) {
            arrayDeque.addFirst(path);
        }
        if (z && arrayDeque.isEmpty()) {
            throw new IOException(dir + " already exist.");
        }
        Iterator<E> it = arrayDeque.iterator();
        while (it.hasNext()) {
            fileSystem.createDirectory((Path) it.next());
        }
    }

    public static final void commonDeleteRecursively(@NotNull FileSystem fileSystem, @NotNull Path fileOrDirectory, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        Iterator it = SequencesKt__SequenceBuilderKt.sequence(new r63(fileSystem, fileOrDirectory, null)).iterator();
        while (it.hasNext()) {
            Path path = (Path) it.next();
            if (z && !it.hasNext()) {
                z2 = true;
            } else {
                z2 = false;
            }
            fileSystem.delete(path, z2);
        }
    }

    public static final boolean commonExists(@NotNull FileSystem fileSystem, @NotNull Path path) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        if (fileSystem.metadataOrNull(path) != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Sequence<Path> commonListRecursively(@NotNull FileSystem fileSystem, @NotNull Path dir, boolean z) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        return SequencesKt__SequenceBuilderKt.sequence(new s63(dir, fileSystem, z, null));
    }

    @NotNull
    public static final FileMetadata commonMetadata(@NotNull FileSystem fileSystem, @NotNull Path path) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    @Nullable
    public static final Path symlinkTarget(@NotNull FileSystem fileSystem, @NotNull Path path) {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path parent = path.parent();
        Intrinsics.checkNotNull(parent);
        return parent.resolve(symlinkTarget);
    }
}
