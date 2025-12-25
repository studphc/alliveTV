package androidx.constraintlayout.core.parser;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import p000.AbstractC1726qj;
import p000.ye0;

/* loaded from: classes.dex */
public class CLContainer extends CLElement {

    /* renamed from: c */
    public ArrayList f2277c;

    public CLContainer(char[] cArr) {
        super(cArr);
        this.f2277c = new ArrayList();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLContainer(cArr);
    }

    public void add(CLElement cLElement) {
        this.f2277c.add(cLElement);
    }

    public void clear() {
        this.f2277c.clear();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLContainer)) {
            return false;
        }
        return this.f2277c.equals(((CLContainer) obj).f2277c);
    }

    public CLElement get(String str) {
        Iterator it = this.f2277c.iterator();
        while (it.hasNext()) {
            CLKey cLKey = (CLKey) ((CLElement) it.next());
            if (cLKey.content().equals(str)) {
                return cLKey.getValue();
            }
        }
        throw new CLParsingException(ye0.m8296p("no element for key <", str, ">"), this);
    }

    public CLArray getArray(String str) {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLArray) {
            return (CLArray) cLElement;
        }
        StringBuilder m7065u = AbstractC1726qj.m7065u("no array found for key <", str, ">, found [");
        m7065u.append(cLElement.getStrClass());
        m7065u.append("] : ");
        m7065u.append(cLElement);
        throw new CLParsingException(m7065u.toString(), this);
    }

    public CLArray getArrayOrCreate(String str) {
        CLArray arrayOrNull = getArrayOrNull(str);
        if (arrayOrNull != null) {
            return arrayOrNull;
        }
        CLArray cLArray = new CLArray(new char[0]);
        put(str, cLArray);
        return cLArray;
    }

    public CLArray getArrayOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLArray) {
            return (CLArray) orNull;
        }
        return null;
    }

    public boolean getBoolean(String str) {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLToken) {
            return ((CLToken) cLElement).getBoolean();
        }
        StringBuilder m7065u = AbstractC1726qj.m7065u("no boolean found for key <", str, ">, found [");
        m7065u.append(cLElement.getStrClass());
        m7065u.append("] : ");
        m7065u.append(cLElement);
        throw new CLParsingException(m7065u.toString(), this);
    }

    public float getFloat(String str) {
        CLElement cLElement = get(str);
        if (cLElement != null) {
            return cLElement.getFloat();
        }
        StringBuilder m7065u = AbstractC1726qj.m7065u("no float found for key <", str, ">, found [");
        m7065u.append(cLElement.getStrClass());
        m7065u.append("] : ");
        m7065u.append(cLElement);
        throw new CLParsingException(m7065u.toString(), this);
    }

    public float getFloatOrNaN(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLNumber) {
            return orNull.getFloat();
        }
        return Float.NaN;
    }

    public int getInt(String str) {
        CLElement cLElement = get(str);
        if (cLElement != null) {
            return cLElement.getInt();
        }
        StringBuilder m7065u = AbstractC1726qj.m7065u("no int found for key <", str, ">, found [");
        m7065u.append(cLElement.getStrClass());
        m7065u.append("] : ");
        m7065u.append(cLElement);
        throw new CLParsingException(m7065u.toString(), this);
    }

    public CLObject getObject(String str) {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLObject) {
            return (CLObject) cLElement;
        }
        StringBuilder m7065u = AbstractC1726qj.m7065u("no object found for key <", str, ">, found [");
        m7065u.append(cLElement.getStrClass());
        m7065u.append("] : ");
        m7065u.append(cLElement);
        throw new CLParsingException(m7065u.toString(), this);
    }

    public CLObject getObjectOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLObject) {
            return (CLObject) orNull;
        }
        return null;
    }

    public CLElement getOrNull(String str) {
        Iterator it = this.f2277c.iterator();
        while (it.hasNext()) {
            CLKey cLKey = (CLKey) ((CLElement) it.next());
            if (cLKey.content().equals(str)) {
                return cLKey.getValue();
            }
        }
        return null;
    }

    public String getString(String str) {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLString) {
            return cLElement.content();
        }
        throw new CLParsingException("no string found for key <" + str + ">, found [" + (cLElement != null ? cLElement.getStrClass() : null) + "] : " + cLElement, this);
    }

    public String getStringOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLString) {
            return orNull.content();
        }
        return null;
    }

    public boolean has(String str) {
        Iterator it = this.f2277c.iterator();
        while (it.hasNext()) {
            CLElement cLElement = (CLElement) it.next();
            if ((cLElement instanceof CLKey) && ((CLKey) cLElement).content().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        return Objects.hash(this.f2277c, Integer.valueOf(super.hashCode()));
    }

    public ArrayList<String> names() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator it = this.f2277c.iterator();
        while (it.hasNext()) {
            CLElement cLElement = (CLElement) it.next();
            if (cLElement instanceof CLKey) {
                arrayList.add(((CLKey) cLElement).content());
            }
        }
        return arrayList;
    }

    public void put(String str, CLElement cLElement) {
        Iterator it = this.f2277c.iterator();
        while (it.hasNext()) {
            CLKey cLKey = (CLKey) ((CLElement) it.next());
            if (cLKey.content().equals(str)) {
                cLKey.set(cLElement);
                return;
            }
        }
        this.f2277c.add((CLKey) CLKey.allocate(str, cLElement));
    }

    public void putNumber(String str, float f) {
        put(str, new CLNumber(f));
    }

    public void putString(String str, String str2) {
        CLString cLString = new CLString(str2.toCharArray());
        cLString.setStart(0L);
        cLString.setEnd(str2.length() - 1);
        put(str, cLString);
    }

    public void remove(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2277c.iterator();
        while (it.hasNext()) {
            CLElement cLElement = (CLElement) it.next();
            if (((CLKey) cLElement).content().equals(str)) {
                arrayList.add(cLElement);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.f2277c.remove((CLElement) it2.next());
        }
    }

    public int size() {
        return this.f2277c.size();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f2277c.iterator();
        while (it.hasNext()) {
            CLElement cLElement = (CLElement) it.next();
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append(cLElement);
        }
        return super.toString() + " = <" + ((Object) sb) + " >";
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CLContainer mo8475clone() {
        CLContainer cLContainer = (CLContainer) super.mo8475clone();
        ArrayList arrayList = new ArrayList(this.f2277c.size());
        Iterator it = this.f2277c.iterator();
        while (it.hasNext()) {
            CLElement mo8475clone = ((CLElement) it.next()).mo8475clone();
            mo8475clone.setContainer(cLContainer);
            arrayList.add(mo8475clone);
        }
        cLContainer.f2277c = arrayList;
        return cLContainer;
    }

    public String getStringOrNull(int i) {
        CLElement orNull = getOrNull(i);
        if (orNull instanceof CLString) {
            return orNull.content();
        }
        return null;
    }

    public CLElement getOrNull(int i) {
        if (i < 0 || i >= this.f2277c.size()) {
            return null;
        }
        return (CLElement) this.f2277c.get(i);
    }

    public String getString(int i) {
        CLElement cLElement = get(i);
        if (cLElement instanceof CLString) {
            return cLElement.content();
        }
        throw new CLParsingException(ye0.m8291k(i, "no string at index "), this);
    }

    public float getFloat(int i) {
        CLElement cLElement = get(i);
        if (cLElement != null) {
            return cLElement.getFloat();
        }
        throw new CLParsingException(ye0.m8291k(i, "no float at index "), this);
    }

    public int getInt(int i) {
        CLElement cLElement = get(i);
        if (cLElement != null) {
            return cLElement.getInt();
        }
        throw new CLParsingException(ye0.m8291k(i, "no int at index "), this);
    }

    public CLArray getArray(int i) {
        CLElement cLElement = get(i);
        if (cLElement instanceof CLArray) {
            return (CLArray) cLElement;
        }
        throw new CLParsingException(ye0.m8291k(i, "no array at index "), this);
    }

    public boolean getBoolean(int i) {
        CLElement cLElement = get(i);
        if (cLElement instanceof CLToken) {
            return ((CLToken) cLElement).getBoolean();
        }
        throw new CLParsingException(ye0.m8291k(i, "no boolean at index "), this);
    }

    public CLObject getObject(int i) {
        CLElement cLElement = get(i);
        if (cLElement instanceof CLObject) {
            return (CLObject) cLElement;
        }
        throw new CLParsingException(ye0.m8291k(i, "no object at index "), this);
    }

    public CLElement get(int i) {
        if (i >= 0 && i < this.f2277c.size()) {
            return (CLElement) this.f2277c.get(i);
        }
        throw new CLParsingException(ye0.m8291k(i, "no element at index "), this);
    }
}
