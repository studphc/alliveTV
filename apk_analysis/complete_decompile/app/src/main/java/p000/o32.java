package p000;

import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.io.path.PathTreeWalk;
import kotlin.io.path.PathTreeWalkKt;
import kotlin.io.path.PathWalkOption;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;

/* loaded from: classes2.dex */
public final class o32 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public ArrayDeque f23585c;

    /* renamed from: d */
    public o40 f23586d;

    /* renamed from: e */
    public l32 f23587e;

    /* renamed from: f */
    public PathTreeWalk f23588f;

    /* renamed from: g */
    public Object f23589g;

    /* renamed from: h */
    public int f23590h;

    /* renamed from: i */
    public /* synthetic */ Object f23591i;

    /* renamed from: j */
    public final /* synthetic */ PathTreeWalk f23592j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o32(PathTreeWalk pathTreeWalk, Continuation continuation) {
        super(2, continuation);
        this.f23592j = pathTreeWalk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        o32 o32Var = new o32(this.f23592j, continuation);
        o32Var.f23591i = obj;
        return o32Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((o32) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0123, code lost:
    
        r6 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        ArrayDeque arrayDeque;
        o40 o40Var;
        boolean contains;
        l32 l32Var;
        Path path;
        Path path2;
        boolean contains2;
        PathTreeWalk pathTreeWalk;
        ArrayDeque arrayDeque2;
        Path path3;
        SequenceScope sequenceScope2;
        l32 l32Var2;
        ArrayDeque arrayDeque3;
        o40 o40Var2;
        LinkOption[] linkOptionArr;
        boolean contains3;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f23590h;
        PathTreeWalk pathTreeWalk2 = this.f23592j;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        Path path4 = (Path) this.f23589g;
                        PathTreeWalk pathTreeWalk3 = this.f23588f;
                        l32 l32Var3 = this.f23587e;
                        o40 o40Var3 = this.f23586d;
                        ArrayDeque arrayDeque4 = this.f23585c;
                        SequenceScope sequenceScope3 = (SequenceScope) this.f23591i;
                        ResultKt.throwOnFailure(obj);
                        SequenceScope sequenceScope4 = sequenceScope3;
                        Path path5 = path4;
                        o40Var2 = o40Var3;
                        l32 l32Var4 = l32Var3;
                        sequenceScope = sequenceScope4;
                        LinkOption[] access$getLinkOptions = PathTreeWalk.access$getLinkOptions(pathTreeWalk3);
                        LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(access$getLinkOptions, access$getLinkOptions.length);
                        if (Files.isDirectory(path5, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                            l32Var4.f22317d = o40Var2.m6439a(l32Var4).iterator();
                            arrayDeque4.addLast(l32Var4);
                        }
                        arrayDeque3 = arrayDeque4;
                        while (!arrayDeque3.isEmpty()) {
                            Iterator it = ((l32) arrayDeque3.last()).f22317d;
                            Intrinsics.checkNotNull(it);
                            if (it.hasNext()) {
                                l32Var4 = (l32) it.next();
                                Path path6 = l32Var4.f22314a;
                                LinkOption[] access$getLinkOptions2 = PathTreeWalk.access$getLinkOptions(pathTreeWalk2);
                                LinkOption[] linkOptionArr3 = (LinkOption[]) Arrays.copyOf(access$getLinkOptions2, access$getLinkOptions2.length);
                                if (Files.isDirectory(path6, (LinkOption[]) Arrays.copyOf(linkOptionArr3, linkOptionArr3.length))) {
                                    if (!PathTreeWalkKt.access$createsCycle(l32Var4)) {
                                        contains3 = ArraysKt___ArraysKt.contains(pathTreeWalk2.f21151b, PathWalkOption.INCLUDE_DIRECTORIES);
                                        if (contains3) {
                                            this.f23591i = sequenceScope;
                                            this.f23585c = arrayDeque3;
                                            this.f23586d = o40Var2;
                                            this.f23587e = l32Var4;
                                            this.f23588f = pathTreeWalk2;
                                            this.f23589g = path6;
                                            this.f23590h = 3;
                                            if (sequenceScope.yield(path6, this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            sequenceScope3 = sequenceScope;
                                            l32Var3 = l32Var4;
                                            o40Var3 = o40Var2;
                                            path4 = path6;
                                            arrayDeque4 = arrayDeque3;
                                            pathTreeWalk3 = pathTreeWalk2;
                                            SequenceScope sequenceScope42 = sequenceScope3;
                                            Path path52 = path4;
                                            o40Var2 = o40Var3;
                                            l32 l32Var42 = l32Var3;
                                            sequenceScope = sequenceScope42;
                                            LinkOption[] access$getLinkOptions3 = PathTreeWalk.access$getLinkOptions(pathTreeWalk3);
                                            LinkOption[] linkOptionArr22 = (LinkOption[]) Arrays.copyOf(access$getLinkOptions3, access$getLinkOptions3.length);
                                            if (Files.isDirectory(path52, (LinkOption[]) Arrays.copyOf(linkOptionArr22, linkOptionArr22.length))) {
                                            }
                                            arrayDeque3 = arrayDeque4;
                                            while (!arrayDeque3.isEmpty()) {
                                            }
                                        } else {
                                            path52 = path6;
                                            arrayDeque4 = arrayDeque3;
                                            pathTreeWalk3 = pathTreeWalk2;
                                            LinkOption[] access$getLinkOptions32 = PathTreeWalk.access$getLinkOptions(pathTreeWalk3);
                                            LinkOption[] linkOptionArr222 = (LinkOption[]) Arrays.copyOf(access$getLinkOptions32, access$getLinkOptions32.length);
                                            if (Files.isDirectory(path52, (LinkOption[]) Arrays.copyOf(linkOptionArr222, linkOptionArr222.length))) {
                                            }
                                            arrayDeque3 = arrayDeque4;
                                            while (!arrayDeque3.isEmpty()) {
                                            }
                                        }
                                    } else {
                                        throw new FileSystemLoopException(path6.toString());
                                    }
                                } else if (Files.exists(path6, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                                    this.f23591i = sequenceScope;
                                    this.f23585c = arrayDeque3;
                                    this.f23586d = o40Var2;
                                    this.f23587e = null;
                                    this.f23588f = null;
                                    this.f23589g = null;
                                    this.f23590h = 4;
                                    if (sequenceScope.yield(path6, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                arrayDeque3.removeLast();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                o40Var2 = this.f23586d;
                arrayDeque3 = this.f23585c;
                sequenceScope = (SequenceScope) this.f23591i;
                ResultKt.throwOnFailure(obj);
                while (!arrayDeque3.isEmpty()) {
                }
                return Unit.INSTANCE;
            }
            path3 = (Path) this.f23589g;
            pathTreeWalk = this.f23588f;
            l32Var2 = this.f23587e;
            o40Var = this.f23586d;
            arrayDeque2 = this.f23585c;
            sequenceScope2 = (SequenceScope) this.f23591i;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.f23591i;
            arrayDeque = new ArrayDeque();
            contains = ArraysKt___ArraysKt.contains(pathTreeWalk2.f21151b, PathWalkOption.FOLLOW_LINKS);
            o40Var = new o40(contains);
            path = pathTreeWalk2.f21150a;
            path2 = pathTreeWalk2.f21150a;
            l32Var = new l32(path, PathTreeWalkKt.access$keyOf(path2, PathTreeWalk.access$getLinkOptions(pathTreeWalk2)), null);
            LinkOption[] access$getLinkOptions4 = PathTreeWalk.access$getLinkOptions(pathTreeWalk2);
            LinkOption[] linkOptionArr4 = (LinkOption[]) Arrays.copyOf(access$getLinkOptions4, access$getLinkOptions4.length);
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr4, linkOptionArr4.length))) {
                if (!PathTreeWalkKt.access$createsCycle(l32Var)) {
                    contains2 = ArraysKt___ArraysKt.contains(pathTreeWalk2.f21151b, PathWalkOption.INCLUDE_DIRECTORIES);
                    if (contains2) {
                        this.f23591i = sequenceScope;
                        this.f23585c = arrayDeque;
                        this.f23586d = o40Var;
                        this.f23587e = l32Var;
                        this.f23588f = pathTreeWalk2;
                        this.f23589g = path;
                        this.f23590h = 1;
                        if (sequenceScope.yield(path, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        pathTreeWalk = pathTreeWalk2;
                        arrayDeque2 = arrayDeque;
                        path3 = path;
                        sequenceScope2 = sequenceScope;
                        l32Var2 = l32Var;
                    } else {
                        pathTreeWalk = pathTreeWalk2;
                        LinkOption[] access$getLinkOptions5 = PathTreeWalk.access$getLinkOptions(pathTreeWalk);
                        linkOptionArr = (LinkOption[]) Arrays.copyOf(access$getLinkOptions5, access$getLinkOptions5.length);
                        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                            l32Var.f22317d = o40Var.m6439a(l32Var).iterator();
                            arrayDeque.addLast(l32Var);
                        }
                        arrayDeque3 = arrayDeque;
                        o40Var2 = o40Var;
                        while (!arrayDeque3.isEmpty()) {
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new FileSystemLoopException(path.toString());
                }
            } else {
                if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                    this.f23591i = sequenceScope;
                    this.f23585c = arrayDeque;
                    this.f23586d = o40Var;
                    this.f23590h = 2;
                    if (sequenceScope.yield(path, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                arrayDeque3 = arrayDeque;
                o40Var2 = o40Var;
                while (!arrayDeque3.isEmpty()) {
                }
                return Unit.INSTANCE;
            }
        }
        SequenceScope sequenceScope5 = sequenceScope2;
        path = path3;
        arrayDeque = arrayDeque2;
        l32Var = l32Var2;
        sequenceScope = sequenceScope5;
        LinkOption[] access$getLinkOptions52 = PathTreeWalk.access$getLinkOptions(pathTreeWalk);
        linkOptionArr = (LinkOption[]) Arrays.copyOf(access$getLinkOptions52, access$getLinkOptions52.length);
        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
        }
        arrayDeque3 = arrayDeque;
        o40Var2 = o40Var;
        while (!arrayDeque3.isEmpty()) {
        }
        return Unit.INSTANCE;
    }
}
