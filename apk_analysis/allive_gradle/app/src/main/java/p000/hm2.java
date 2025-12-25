package p000;

import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import java.util.Date;

/* loaded from: classes2.dex */
public final class hm2 extends DefaultDateTypeAdapter.DateType {
    @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
    public final Date deserialize(Date date) {
        return new java.sql.Date(date.getTime());
    }
}
