import type { Unit } from "uom";
import { Units } from "uom-units";

export interface ConverterOption {
  id: number;
  unit: Unit.Unit<any>;
}

export type CategoryColors = [normal: string, active: string, hover: string];

//Object Basics
enum CategoryItems {
  LENGTH = 0,
  TEMPERATURE,
  MASS,
  VOLUME,
  PRESSURE,
  ENERGY,
}

namespace CategoryItems {
  export function allItems(): CategoryItems[] {
    return new Array(
      CategoryItems.LENGTH,
      CategoryItems.TEMPERATURE,
      CategoryItems.MASS,
      CategoryItems.VOLUME,
      CategoryItems.PRESSURE,
      CategoryItems.ENERGY
    );
  }

  export function displayLabel(item: CategoryItems): string {
    switch (item) {
      case CategoryItems.LENGTH:
        return "Length";
      case CategoryItems.TEMPERATURE:
        return "Temperature";
      case CategoryItems.MASS:
        return "Mass";
      case CategoryItems.VOLUME:
        return "Volume";
      case CategoryItems.PRESSURE:
        return "Pressure";
      case CategoryItems.ENERGY:
        return "Energy";
    }
  }

  export function itemColors(item: CategoryItems): CategoryColors {
    switch (item) {
      case CategoryItems.LENGTH:
        return ["bg-blue-500", "active:bg-blue-800", "hover:bg-blue-700"];
      case CategoryItems.TEMPERATURE:
        return ["bg-red-500", "active:bg-red-800", "hover:bg-red-700"];
      case CategoryItems.MASS:
        return ["bg-purple-500", "active:bg-purple-800", "hover:bg-purple-700"];
      case CategoryItems.VOLUME:
        return ["bg-orange-500", "active:bg-orange-800", "hover:bg-orange-700"];
      case CategoryItems.PRESSURE:
        return [
          "bg-emerald-500",
          "active:bg-emerald-800",
          "hover:bg-emerald-700",
        ];
      case CategoryItems.ENERGY:
        return ["bg-yellow-500", "active:bg-yellow-800", "hover:bg-yellow-700"];
    }
  }

  export function itemIcon(item: CategoryItems): string {
    switch (item) {
      case CategoryItems.LENGTH:
        return "fas fa-ruler";
      case CategoryItems.TEMPERATURE:
        return "fas fa-fire";
      case CategoryItems.MASS:
        return "fas fa-weight-scale";
      case CategoryItems.VOLUME:
        return "fas fa-droplet";
      case CategoryItems.PRESSURE:
        return "fas fa-gauge-simple";
      case CategoryItems.ENERGY:
        return "fas fa-bolt";
      default:
        break;
    }
  }

  export function defaultUnit(item: CategoryItems): Unit.Unit<any> {
    switch (item) {
      case CategoryItems.LENGTH:
        return Units.Foot;
      case CategoryItems.TEMPERATURE:
        return Units.Fahrenheit;
      case CategoryItems.MASS:
        return Units.Gram;
      case CategoryItems.VOLUME:
        return Units.Gallon;
      case CategoryItems.PRESSURE:
        return Units.PoundForcePerSquareInch;
      case CategoryItems.ENERGY:
        return Units.Joule;
    }
  }

  export function convertableUnits(item: CategoryItems): ConverterOption[] {
    switch (item) {
      case CategoryItems.LENGTH:
        return [
          { id: 0, unit: Units.Foot },
          { id: 1, unit: Units.Inch },
          { id: 2, unit: Units.Mile },
          { id: 3, unit: Units.Meter },
          { id: 4, unit: Units.CentiMeter },
          { id: 5, unit: Units.Millimeter },
          { id: 6, unit: Units.Kilometer },
        ];
      case CategoryItems.TEMPERATURE:
        return [
          { id: 0, unit: Units.Fahrenheit },
          { id: 1, unit: Units.Celsius },
          { id: 2, unit: Units.Kelvin },
        ];
      case CategoryItems.MASS:
        return [
          { id: 0, unit: Units.Gram },
          { id: 1, unit: Units.Kilogram },
          { id: 2, unit: Units.MilliGram },
          { id: 3, unit: Units.PoundLb },
        ];
      case CategoryItems.VOLUME:
        return [
          { id: 0, unit: Units.Liter },
          { id: 1, unit: Units.MilliLiter },
          { id: 2, unit: Units.Gallon },
          { id: 3, unit: Units.CubicFeet },
          { id: 4, unit: Units.CubicMeter },
        ];
      case CategoryItems.PRESSURE:
        return [
          { id: 0, unit: Units.PoundForcePerSquareInch },
          { id: 1, unit: Units.Pascal },
          { id: 2, unit: Units.KiloPascal },
          { id: 3, unit: Units.Bar },
          { id: 4, unit: Units.MilliBar },
        ];
      case CategoryItems.ENERGY:
        return [
          { id: 0, unit: Units.Joule },
          { id: 1, unit: Units.Kilojoule },
          { id: 2, unit: Units.MegaWattHour },
          { id: 3, unit: Units.Therm },
        ];
    }
  }
}

//UI Items
interface CategoryItem {
  id: number;
  option: CategoryItems;
  title: string;
  colors: [normal: string, active: string, hover: string];
  icon: string;
  converterOptions: ConverterOption[];
}

export class CategoryCard implements CategoryItem {
  id: number;
  option: CategoryItems;
  title: string;
  colors: CategoryColors;
  icon: string;
  converterOptions: ConverterOption[];

  constructor(public item: CategoryItems) {
    this.id = item.valueOf();
    this.option = item;
    this.title = CategoryItems.displayLabel(item);
    this.colors = CategoryItems.itemColors(item);
    this.icon = CategoryItems.itemIcon(item);
    this.converterOptions = CategoryItems.convertableUnits(item);
  }
}

export const allCategoryCards: CategoryCard[] = CategoryItems.allItems().map(
  (item) => new CategoryCard(item)
);
