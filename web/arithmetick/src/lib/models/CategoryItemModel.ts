import type { Unit } from "uom";
import { Units } from "uom-units";

export interface ConverterOption {
  id: number;
  unit: Unit.Unit<any>;
}
//Object basics
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
  export function itemColor(item: CategoryItems): string {
    switch (item) {
      case CategoryItems.LENGTH:
        return "bg-blue-500";
      case CategoryItems.TEMPERATURE:
        return "bg-red-500";
      case CategoryItems.MASS:
        return "bg-purple-500";
      case CategoryItems.VOLUME:
        return "bg-orange-500";
      case CategoryItems.PRESSURE:
        return "bg-emerald-500";
      case CategoryItems.ENERGY:
        return "bg-cyan-500";
      default:
        break;
    }
  }
  export function itemActiveColor(item: CategoryItems): string {
    switch (item) {
      case CategoryItems.LENGTH:
        return "active:bg-blue-800";
      case CategoryItems.TEMPERATURE:
        return "active:bg-red-800";
      case CategoryItems.MASS:
        return "active:bg-purple-800";
      case CategoryItems.VOLUME:
        return "active:bg-orange-800";
      case CategoryItems.PRESSURE:
        return "active:bg-emerald-800";
      case CategoryItems.ENERGY:
        return "active:bg-cyan-800";
      default:
        break;
    }
  }
  export function itemHoverColor(item: CategoryItems): string {
    switch (item) {
      case CategoryItems.LENGTH:
        return "hover:bg-blue-800";
      case CategoryItems.TEMPERATURE:
        return "hover:bg-red-800";
      case CategoryItems.MASS:
        return "hover:bg-purple-800";
      case CategoryItems.VOLUME:
        return "hover:bg-orange-800";
      case CategoryItems.PRESSURE:
        return "hover:bg-emerald-800";
      case CategoryItems.ENERGY:
        return "hover:bg-cyan-800";
      default:
        break;
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
          { id: 3, unit: Units.Rankine },
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
      default:
        break;
    }
  }
}

//UI basics
interface CategoryItem {
  id: number;
  option: CategoryItems;
  title: string;
  color: string;
  activeColor: string;
  hoverColor: string;
  icon: string;
  converterOptions: ConverterOption[];
}

export class CategoryCard implements CategoryItem {
  id: number;
  option: CategoryItems;
  title: string;
  color: string;
  activeColor: string;
  hoverColor: string;
  icon: string;
  converterOptions: ConverterOption[];

  constructor(public item: CategoryItems) {
    this.option = item;
    this.id = item.valueOf();
    this.title = CategoryItems.displayLabel(item);
    this.color = CategoryItems.itemColor(item);
    this.activeColor = CategoryItems.itemActiveColor(item);
    this.hoverColor = CategoryItems.itemHoverColor(item);
    this.icon = CategoryItems.itemIcon(item);
    this.converterOptions = CategoryItems.convertableUnits(item);
  }
}

export const allCategoryCards: CategoryCard[] = CategoryItems.allItems().map(
  (item) => new CategoryCard(item)
);
