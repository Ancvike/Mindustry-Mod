Thanks to Sharlottes's Informatis mod for helping with the mod.
Thanks to miner's coreItems mod for helping with the mod.

以下是 Mindustry Java 模组模板的翻译，适用于 Android 和 PC。

构建桌面测试版本
安装 JDK 17。
运行 gradlew jar [1]。
你的模组 jar 文件将位于 build/libs 目录下。此版本仅用于桌面测试，无法在 Android 上运行。要构建兼容 Android 的版本，你需要 Android SDK。你可以选择让 GitHub Actions 处理此过程，或自行设置。请参见以下步骤。
通过 GitHub Actions 构建
此存储库已设置 GitHub Actions CI，以便在每次提交时自动构建模组。这需要一个 GitHub 存储库，显而易见。要获取一个适用于所有平台的 jar 文件，请执行以下操作：

创建一个 GitHub 存储库，命名为你的模组名称，并将此存储库的内容上传到其中。根据需要进行任何修改，然后提交并推送。
检查存储库页面上的“Actions”选项卡。在列表中选择最近的提交。如果成功完成，应该会在“Artifacts”部分下有一个下载链接。
点击下载链接（应为你的存储库名称）。这将下载一个压缩的 jar 文件，而不是 jar 文件本身 [2]！解压此文件，并将其中的 jar 导入 Mindustry。此版本应同时适用于 Android 和桌面。
本地构建
本地构建需要更多时间进行设置，但如果你有 Android 开发经验，这不应该是问题。

下载 Android SDK，解压并将 ANDROID_HOME 环境变量设置为其位置。
确保已安装 API 级别 30，以及任何最近版本的构建工具（例如 30.0.1）。
将构建工具文件夹添加到你的 PATH 中。例如，如果你安装了 30.0.1，则路径为 $ANDROID_HOME/build-tools/30.0.1。
运行 gradlew deploy。如果一切正确，这将创建一个可以在 Android 和桌面上运行的 jar 文件，位于 build/libs 目录下。
添加依赖项
请注意，所有对 Mindustry、Arc 或其子模块的依赖项必须在 Gradle 中声明为 compileOnly。切勿对核心 Mindustry 或 Arc 依赖项使用 implementation。

implementation 会将整个依赖项包含在 jar 中，而在大多数模组依赖项中，这通常是不可取的。你不希望将整个 Mindustry API 包含在你的模组中。
compileOnly 意味着该依赖项仅在编译时存在，而不包含在 jar 中。
仅在你想要将另一个 Java 库与模组打包，并且该库在 Mindustry 中尚不存在时，才使用 implementation。
[1] 在 Linux/Mac 上为 ./gradlew，但如果你使用 Linux，我假设你知道如何正确运行可执行文件。
[2] 是的，我知道这很愚蠢。这是 GitHub UI 的限制——尽管 jar 本身是以未压缩形式上传的，但目前没有办法以单个文件下载它。