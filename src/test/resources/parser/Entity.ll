target triple = 'qwe'
attributes #1={alwaysinline}
$a = comdat any
!b = distinct !'string'
%integer = type i8 *
@b=global i8 1

declare i32 @printf(i8*, ...) #1

define i8 @add() {
  ret i8 0
}

