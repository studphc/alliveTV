package androidx.core.app;

import android.app.Person;
import android.graphics.drawable.Icon;
import androidx.annotation.DoNotInline;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;

/* renamed from: androidx.core.app.i0 */
/* loaded from: classes.dex */
public abstract class AbstractC0155i0 {
    @DoNotInline
    /* renamed from: a */
    public static Person m740a(android.app.Person person) {
        IconCompat iconCompat;
        Person.Builder name = new Person.Builder().setName(person.getName());
        if (person.getIcon() != null) {
            iconCompat = IconCompat.createFromIcon(person.getIcon());
        } else {
            iconCompat = null;
        }
        return name.setIcon(iconCompat).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
    }

    @DoNotInline
    /* renamed from: b */
    public static android.app.Person m741b(Person person) {
        Icon icon;
        Person.Builder name = new Person.Builder().setName(person.getName());
        if (person.getIcon() != null) {
            icon = person.getIcon().toIcon();
        } else {
            icon = null;
        }
        return name.setIcon(icon).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
    }
}
