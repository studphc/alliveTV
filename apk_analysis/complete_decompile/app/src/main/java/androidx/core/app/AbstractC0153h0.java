package androidx.core.app;

import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.core.app.Person;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

/* renamed from: androidx.core.app.h0 */
/* loaded from: classes.dex */
public abstract class AbstractC0153h0 {
    @DoNotInline
    /* renamed from: a */
    public static Person m735a(PersistableBundle persistableBundle) {
        return new Person.Builder().setName(persistableBundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME)).setUri(persistableBundle.getString("uri")).setKey(persistableBundle.getString("key")).setBot(persistableBundle.getBoolean("isBot")).setImportant(persistableBundle.getBoolean("isImportant")).build();
    }

    @DoNotInline
    /* renamed from: b */
    public static PersistableBundle m736b(Person person) {
        String str;
        PersistableBundle persistableBundle = new PersistableBundle();
        CharSequence charSequence = person.f3470a;
        if (charSequence != null) {
            str = charSequence.toString();
        } else {
            str = null;
        }
        persistableBundle.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
        persistableBundle.putString("uri", person.f3472c);
        persistableBundle.putString("key", person.f3473d);
        persistableBundle.putBoolean("isBot", person.f3474e);
        persistableBundle.putBoolean("isImportant", person.f3475f);
        return persistableBundle;
    }
}
