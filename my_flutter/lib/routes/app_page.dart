import 'package:get/get.dart';

import 'route_name.dart';

//pages
import '../screens/home/index.dart';
import '../screens/secondary/index.dart';

class AppPage {
  static final pages = [
    GetPage(
      name: RouteName.home,
      page: () => Home(),
    ),
    GetPage(
      name: RouteName.secondary,
      page: () => Secondary(),
    ),
  ];
}
