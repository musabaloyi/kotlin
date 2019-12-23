// !WITH_NEW_INFERENCE
//KT-2164 !! does not propagate nullability information
package kt2164

fun foo(x: Int): Int = x + 1

fun main() {
    val x: Int? = null

    foo(<!TYPE_MISMATCH!>x<!>)

    if (x != null) {
        foo(<!DEBUG_INFO_SMARTCAST!>x<!>)
        foo(x<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>)
        foo(<!DEBUG_INFO_SMARTCAST!>x<!>)
    }

    foo(<!TYPE_MISMATCH!>x<!>)

    if (x != null) {
        foo(<!DEBUG_INFO_SMARTCAST!>x<!>)
        foo(x<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>)
        foo(<!DEBUG_INFO_SMARTCAST!>x<!>)
    } else {
        foo(<!DEBUG_INFO_CONSTANT, TYPE_MISMATCH!>x<!>)
        <!OI;UNREACHABLE_CODE!>foo(<!><!ALWAYS_NULL!>x<!>!!<!OI;UNREACHABLE_CODE!>)<!>
        <!OI;UNREACHABLE_CODE!><!NI;UNREACHABLE_CODE!>foo(<!><!DEBUG_INFO_SMARTCAST!>x<!><!NI;UNREACHABLE_CODE!>)<!><!>
    }

    foo(<!DEBUG_INFO_SMARTCAST!>x<!>)
    foo(x<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>)
    foo(<!DEBUG_INFO_SMARTCAST!>x<!>)
    
    val y: Int? = null
    y!!
    y<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>
    foo(<!DEBUG_INFO_SMARTCAST!>y<!>)
    foo(y<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>)
}
