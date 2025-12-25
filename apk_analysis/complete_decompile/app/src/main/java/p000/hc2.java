package p000;

import com.google.firebase.components.DependencyException;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import java.util.Set;

/* loaded from: classes2.dex */
public final class hc2 implements Publisher {

    /* renamed from: a */
    public final Set f18020a;

    /* renamed from: b */
    public final Publisher f18021b;

    public hc2(Set set, Publisher publisher) {
        this.f18020a = set;
        this.f18021b = publisher;
    }

    @Override // com.google.firebase.events.Publisher
    public final void publish(Event event) {
        if (this.f18020a.contains(event.getType())) {
            this.f18021b.publish(event);
            return;
        }
        throw new DependencyException(String.format("Attempting to publish an undeclared event %s.", event));
    }
}
