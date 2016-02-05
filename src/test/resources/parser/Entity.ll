target triple = 'qwe'
attributes #1={alwaysinline}
$a = comdat any
!b = distinct !'string'
%integer=type i8 *
@b=global i8 1

declare i32 @printf(i8*, ...) #1

define i8 @add() {
  ret i8 0
}


;Copied directly from the documentation
; Declare the string constant as a global constant.
@.str = private unnamed_addr constant [13 x i8] c'hello world\0A\00'

; External declaration of the puts function
declare i32 @puts(i8* nocapture) nounwind

; Definition of main function
define i32 @main() {   ; i32()*
      ; Convert [13 x i8]* to i8  *...
        %cast210 = getelementptr i8, [13 x i8]* @.str, i64 0, i64 0

          ; Call puts function to write out the string to stdout.
            call i32 @puts(i8* %cast210)
              ret i32 0
}

; Named metadata
!1 =  !{i32 42}
!foo = !{!1, !1}
