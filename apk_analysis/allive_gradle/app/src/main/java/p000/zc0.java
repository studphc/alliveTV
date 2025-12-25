package p000;

import com.google.common.collect.ImmutableList;
import com.google.common.graph.SuccessorsFunction;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class zc0 implements SuccessorsFunction {
    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    public final Iterable successors(Object obj) {
        File[] listFiles;
        File file = (File) obj;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            return Collections.unmodifiableList(Arrays.asList(listFiles));
        }
        return ImmutableList.m3902of();
    }
}
