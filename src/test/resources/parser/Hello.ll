; ModuleID = 'hello'
@.str = private constant [14 x i8] c"Hello, World!\00"
declare i32 @puts(i8* nocapture) nounwind
define i32 @main() {
  %1 = call i32 @puts(i8* getelementptr inbounds  ([14 x i8],[14 x i8]* @.str, i32 0, i32 0))
  ret i32 0
}