# 设置 pom.xml 中的项目版本号
#-----------------------------------------------------------------
# 命令执行示例：
# bin/set_version.ps1 [old_version] [new_version]
#-----------------------------------------------------------------

$OLD_VERSION = "<version>" + ${args}[0] + "</version>"
$NEW_VERSION = "<version>" + ${args}[1] + "</version>"
$POM_PATH = "./pom.xml"

Write-Output "Set versions for all modules : $NEW_VERSION"
bin/_sed.ps1 $OLD_VERSION $NEW_VERSION $POM_PATH

$items = Get-ChildItem . "exp-libs-*"
Foreach($item in $items) {
    Write-Output "Set versions for $item : $NEW_VERSION"
    $pomPath = Get-ChildItem "./$item/pom.xml"
    If(Test-Path $pomPath) {
        bin/_sed.ps1 $OLD_VERSION $NEW_VERSION $pomPath
    }
}
Write-Output "Done ."
