import { Amount, UnitFormat } from "uom";
import { UnitsFormat } from "uom-units";
import { round } from "reliable-round";
import type {
  CategoryCard,
  ConverterOption,
} from "../models/CategoryItemModel";

export interface ConvertedResultItem {
  option: ConverterOption;
  value: number;
}

export class ConverterViewModel {
  category: CategoryCard;
  selectedUnit: ConverterOption;

  constructor(item: CategoryCard, selectedUnit: number) {
    this.category = item;
    let options = item.converterOptions;
    this.selectedUnit = options.find((item) => item.id == selectedUnit);
  }

  getConvertedValues(inputString: string): ConvertedResultItem[] {
    let numberValue = Number(inputString);
    let currentAmount = Amount.create(numberValue, this.selectedUnit.unit);
    let conversions = this.category.converterOptions.map((item) =>
      this.getFormattedValue(item, currentAmount)
    );
    let filteredResults = conversions.filter(
      (item) => item.option.unit != this.selectedUnit.unit
    );
    return filteredResults;
  }

  getFormattedValue(
    item: ConverterOption,
    currentAmount: Amount.Amount<any>
  ): ConvertedResultItem {
    let formatter = UnitFormat.getUnitFormat(item.unit, UnitsFormat);
    let convertedAmount = Amount.valueAs(item.unit, currentAmount);
    let formattedAmount = round(convertedAmount, formatter.decimalCount);
    let result: ConvertedResultItem = {
      option: { id: item.id, unit: item.unit },
      value: formattedAmount,
    };
    return result;
  }
}
