package p000;

import com.google.common.reflect.TypeToken;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* loaded from: classes2.dex */
public enum fy2 extends hy2 {
    public fy2() {
        super("IGNORE_TYPE_VARIABLE_OR_WILDCARD", 0);
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        Type type = ((TypeToken) obj).f15237a;
        if (!(type instanceof TypeVariable) && !(type instanceof WildcardType)) {
            return true;
        }
        return false;
    }
}
