package p000;

import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
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
import kotlin.sequences.SequenceScope;

/* loaded from: classes2.dex */
public final class n32 extends RestrictedSuspendLambda implements Function2 {

    /* renamed from: c */
    public ArrayDeque f23211c;

    /* renamed from: d */
    public o40 f23212d;

    /* renamed from: e */
    public l32 f23213e;

    /* renamed from: f */
    public PathTreeWalk f23214f;

    /* renamed from: g */
    public Object f23215g;

    /* renamed from: h */
    public int f23216h;

    /* renamed from: i */
    public /* synthetic */ Object f23217i;

    /* renamed from: j */
    public final /* synthetic */ PathTreeWalk f23218j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n32(PathTreeWalk pathTreeWalk, Continuation continuation) {
        super(2, continuation);
        this.f23218j = pathTreeWalk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        n32 n32Var = new n32(this.f23218j, continuation);
        n32Var.f23217i = obj;
        return n32Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((n32) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
    
        r6 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0071  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean contains;
        Path path;
        Path path2;
        SequenceScope sequenceScope;
        ArrayDeque arrayDeque;
        o40 o40Var;
        l32 l32Var;
        ArrayDeque arrayDeque2;
        Path path3;
        PathTreeWalk pathTreeWalk;
        LinkOption[] linkOptionArr;
        SequenceScope sequenceScope2;
        o40 o40Var2;
        l32 l32Var2;
        Path path4;
        boolean contains2;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f23216h;
        PathTreeWalk pathTreeWalk2 = this.f23218j;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    o40Var = this.f23212d;
                    arrayDeque = this.f23211c;
                    sequenceScope = (SequenceScope) this.f23217i;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                path4 = (Path) this.f23215g;
                pathTreeWalk = this.f23214f;
                l32Var2 = this.f23213e;
                o40Var2 = this.f23212d;
                arrayDeque2 = this.f23211c;
                sequenceScope2 = (SequenceScope) this.f23217i;
                ResultKt.throwOnFailure(obj);
                l32Var = l32Var2;
                sequenceScope = sequenceScope2;
                o40 o40Var3 = o40Var2;
                path3 = path4;
                o40Var = o40Var3;
                LinkOption[] access$getLinkOptions = PathTreeWalk.access$getLinkOptions(pathTreeWalk);
                linkOptionArr = (LinkOption[]) Arrays.copyOf(access$getLinkOptions, access$getLinkOptions.length);
                if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                    arrayDeque2.addAll(o40Var.m6439a(l32Var));
                }
                arrayDeque = arrayDeque2;
            }
        } else {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope3 = (SequenceScope) this.f23217i;
            ArrayDeque arrayDeque3 = new ArrayDeque();
            contains = ArraysKt___ArraysKt.contains(pathTreeWalk2.f21151b, PathWalkOption.FOLLOW_LINKS);
            o40 o40Var4 = new o40(contains);
            path = pathTreeWalk2.f21150a;
            path2 = pathTreeWalk2.f21150a;
            arrayDeque3.addLast(new l32(path, PathTreeWalkKt.access$keyOf(path2, PathTreeWalk.access$getLinkOptions(pathTreeWalk2)), null));
            sequenceScope = sequenceScope3;
            arrayDeque = arrayDeque3;
            o40Var = o40Var4;
        }
        while (!arrayDeque.isEmpty()) {
            l32Var = (l32) arrayDeque.removeFirst();
            path3 = l32Var.f22314a;
            LinkOption[] access$getLinkOptions2 = PathTreeWalk.access$getLinkOptions(pathTreeWalk2);
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(access$getLinkOptions2, access$getLinkOptions2.length);
            if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                if (!PathTreeWalkKt.access$createsCycle(l32Var)) {
                    contains2 = ArraysKt___ArraysKt.contains(pathTreeWalk2.f21151b, PathWalkOption.INCLUDE_DIRECTORIES);
                    if (contains2) {
                        this.f23217i = sequenceScope;
                        this.f23211c = arrayDeque;
                        this.f23212d = o40Var;
                        this.f23213e = l32Var;
                        this.f23214f = pathTreeWalk2;
                        this.f23215g = path3;
                        this.f23216h = 1;
                        if (sequenceScope.yield(path3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        arrayDeque2 = arrayDeque;
                        sequenceScope2 = sequenceScope;
                        l32Var2 = l32Var;
                        pathTreeWalk = pathTreeWalk2;
                        o40Var2 = o40Var;
                        path4 = path3;
                        l32Var = l32Var2;
                        sequenceScope = sequenceScope2;
                        o40 o40Var32 = o40Var2;
                        path3 = path4;
                        o40Var = o40Var32;
                        LinkOption[] access$getLinkOptions3 = PathTreeWalk.access$getLinkOptions(pathTreeWalk);
                        linkOptionArr = (LinkOption[]) Arrays.copyOf(access$getLinkOptions3, access$getLinkOptions3.length);
                        if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                        }
                        arrayDeque = arrayDeque2;
                        while (!arrayDeque.isEmpty()) {
                        }
                    } else {
                        arrayDeque2 = arrayDeque;
                        pathTreeWalk = pathTreeWalk2;
                        LinkOption[] access$getLinkOptions32 = PathTreeWalk.access$getLinkOptions(pathTreeWalk);
                        linkOptionArr = (LinkOption[]) Arrays.copyOf(access$getLinkOptions32, access$getLinkOptions32.length);
                        if (Files.isDirectory(path3, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
                        }
                        arrayDeque = arrayDeque2;
                        while (!arrayDeque.isEmpty()) {
                        }
                    }
                } else {
                    throw new FileSystemLoopException(path3.toString());
                }
            } else if (Files.exists(path3, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                this.f23217i = sequenceScope;
                this.f23211c = arrayDeque;
                this.f23212d = o40Var;
                this.f23213e = null;
                this.f23214f = null;
                this.f23215g = null;
                this.f23216h = 2;
                if (sequenceScope.yield(path3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
