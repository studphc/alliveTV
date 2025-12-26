package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1204fq;
import p000.AbstractC1327iq;
import p000.C1829tb;
import p000.t71;
import p000.wb2;

@Metadata(m5568d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001+B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\"\u0010!J\u001f\u0010$\u001a\u00020#2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020#2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010%J\u001f\u0010*\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b*\u0010(¨\u0006,"}, m5569d2 = {"Lokio/internal/ResourceFileSystem;", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "classLoader", "", "indexEagerly", "<init>", "(Ljava/lang/ClassLoader;Z)V", "Lokio/Path;", "path", "canonicalize", "(Lokio/Path;)Lokio/Path;", "dir", "", "list", "(Lokio/Path;)Ljava/util/List;", "listOrNull", "file", "Lokio/FileHandle;", "openReadOnly", "(Lokio/Path;)Lokio/FileHandle;", "mustCreate", "mustExist", "openReadWrite", "(Lokio/Path;ZZ)Lokio/FileHandle;", "Lokio/FileMetadata;", "metadataOrNull", "(Lokio/Path;)Lokio/FileMetadata;", "Lokio/Source;", FirebaseAnalytics.Param.SOURCE, "(Lokio/Path;)Lokio/Source;", "Lokio/Sink;", "sink", "(Lokio/Path;Z)Lokio/Sink;", "appendingSink", "", "createDirectory", "(Lokio/Path;Z)V", TypedValues.AttributesType.S_TARGET, "atomicMove", "(Lokio/Path;Lokio/Path;)V", "delete", "createSymlink", "wb2", "okio"}, m5570k = 1, m5571mv = {1, 6, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ResourceFileSystem extends FileSystem {

    /* renamed from: b */
    public static final wb2 f24779b = new Object();

    /* renamed from: c */
    public static final Path f24780c = Path.Companion.get$default(Path.INSTANCE, "/", false, 1, (Object) null);

    /* renamed from: a */
    public final Lazy f24781a;

    public ResourceFileSystem(@NotNull ClassLoader classLoader, boolean z) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.f24781a = t71.lazy(new C1829tb(11, classLoader));
        if (z) {
            m6674a().size();
        }
    }

    public static final /* synthetic */ wb2 access$getCompanion$p() {
        return f24779b;
    }

    public static final /* synthetic */ Path access$getROOT$cp() {
        return f24780c;
    }

    /* renamed from: b */
    public static String m6673b(Path path) {
        Path path2 = f24780c;
        return path2.resolve(path, true).relativeTo(path2).toString();
    }

    /* renamed from: a */
    public final List m6674a() {
        return (List) this.f24781a.getValue();
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink appendingSink(@NotNull Path file, boolean mustExist) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(@NotNull Path r2, @NotNull Path r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    @NotNull
    public Path canonicalize(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return f24780c.resolve(path, true);
    }

    @Override // okio.FileSystem
    public void createDirectory(@NotNull Path dir, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(@NotNull Path r2, @NotNull Path r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "target");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void delete(@NotNull Path path, boolean mustExist) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    @NotNull
    public List<Path> list(@NotNull Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        String m6673b = m6673b(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = false;
        for (Pair pair : m6674a()) {
            FileSystem fileSystem = (FileSystem) pair.component1();
            Path path = (Path) pair.component2();
            try {
                List<Path> list = fileSystem.list(path.resolve(m6673b));
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    wb2 wb2Var = f24779b;
                    if (!hasNext) {
                        break;
                    }
                    Object next = it.next();
                    if (wb2.m8019a(wb2Var, (Path) next)) {
                        arrayList.add(next);
                    }
                }
                ArrayList arrayList2 = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(wb2.m8020b((Path) it2.next(), path));
                }
                AbstractC1327iq.addAll(linkedHashSet, arrayList2);
                z = true;
            } catch (IOException unused) {
            }
        }
        if (z) {
            return CollectionsKt___CollectionsKt.toList(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + dir);
    }

    @Override // okio.FileSystem
    @Nullable
    public List<Path> listOrNull(@NotNull Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        String m6673b = m6673b(dir);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = m6674a().iterator();
        boolean z = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            Pair pair = (Pair) it.next();
            FileSystem fileSystem = (FileSystem) pair.component1();
            Path path = (Path) pair.component2();
            List<Path> listOrNull = fileSystem.listOrNull(path.resolve(m6673b));
            if (listOrNull != null) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it2 = listOrNull.iterator();
                while (true) {
                    boolean hasNext = it2.hasNext();
                    wb2 wb2Var = f24779b;
                    if (!hasNext) {
                        break;
                    }
                    Object next = it2.next();
                    if (wb2.m8019a(wb2Var, (Path) next)) {
                        arrayList2.add(next);
                    }
                }
                ArrayList arrayList3 = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(arrayList2, 10));
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(wb2.m8020b((Path) it3.next(), path));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                AbstractC1327iq.addAll(linkedHashSet, arrayList);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return CollectionsKt___CollectionsKt.toList(linkedHashSet);
    }

    @Override // okio.FileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!wb2.m8019a(f24779b, path)) {
            return null;
        }
        String m6673b = m6673b(path);
        for (Pair pair : m6674a()) {
            FileMetadata metadataOrNull = ((FileSystem) pair.component1()).metadataOrNull(((Path) pair.component2()).resolve(m6673b));
            if (metadataOrNull != null) {
                return metadataOrNull;
            }
        }
        return null;
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadOnly(@NotNull Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (wb2.m8019a(f24779b, file)) {
            String m6673b = m6673b(file);
            for (Pair pair : m6674a()) {
                try {
                    return ((FileSystem) pair.component1()).openReadOnly(((Path) pair.component2()).resolve(m6673b));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + file);
        }
        throw new FileNotFoundException("file not found: " + file);
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadWrite(@NotNull Path file, boolean mustCreate, boolean mustExist) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("resources are not writable");
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink sink(@NotNull Path file, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    @NotNull
    public Source source(@NotNull Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (wb2.m8019a(f24779b, file)) {
            String m6673b = m6673b(file);
            for (Pair pair : m6674a()) {
                try {
                    return ((FileSystem) pair.component1()).source(((Path) pair.component2()).resolve(m6673b));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + file);
        }
        throw new FileNotFoundException("file not found: " + file);
    }
}
